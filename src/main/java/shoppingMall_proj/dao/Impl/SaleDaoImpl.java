package shoppingMall_proj.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import shoppingMall_proj.dao.SaleDao;
import shoppingMall_proj.dto.Customer;
import shoppingMall_proj.dto.Product;
import shoppingMall_proj.dto.Sale;
import shoppingMall_proj.dto.util.JdbcUtil;

public class SaleDaoImpl implements SaleDao {
	private static SaleDaoImpl instance = new SaleDaoImpl();

	private SaleDaoImpl() {

	}

	public static SaleDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Sale> selectSaleByAll() {
		String sql = "select orderNo, date, csNo, pCode, saleAmount from sale";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Sale> list = new ArrayList<>();
				do {
					list.add(getSale(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	private Sale getSale(ResultSet rs) throws SQLException {
		int orderNo = 0;
		String date = null;
		Customer csNo = null;
		Product pCode = null;
		int saleAmount = 0;
		int Selling = 0;
		int Profit = 0;
		/*
		 * 예외처리를 해주는 이유
		 * getSale()메소드는 sale객체를 생성해서 반환해주는데 이때 생성자는 매개변수로 Sale클래스에 선언된 모든 필드가 들어가있다.
		 * 만약 view를 생성해서 쿼리문을 작성하거나 혹은 검색하고자 하는게 모든 필드를 포함하지 않을 경우 getSale()메소드를 호출하면
		 * 칼럼을 찾을 수 없다는 오류가 발생한다.
		 * 그럴땐 getSale**()메소드를 생성해서 원하는 부분만 매개변수로 하는 생성자로 객체를 반환해주게 하면되지만 결국 코드 중복이 일어난다.
		 * try-catch문의 경우 try문에서 예외가 발생하지 않을 경우에 그냥 지나가고, 예외발생시, 예외를 던져주면 된다.
		 * try-catch문은*/
		try {
			System.out.println(rs.getString("csName"));

			Profit = rs.getInt("profit");
			Selling = rs.getInt("selling");
			saleAmount = rs.getInt("saleAmount");
			pCode = new Product(rs.getString("pCode"));
			csNo = new Customer(rs.getInt("csNo"));
			date = rs.getString("date");
			orderNo = rs.getInt("orderNo");
			csNo.setCsName(rs.getString("csName"));
			csNo.setBirth(rs.getString("birth"));
			csNo.setPhoneNo(rs.getString("phoneNo"));
			csNo.setSex(rs.getInt("sex"));
			pCode.setpName(rs.getString("pName"));
			pCode.setPrice(rs.getInt("price"));
			pCode.setStockAmount(rs.getInt("stockAmount"));
		} catch (SQLException e) {
		}

		return new Sale(orderNo, date, csNo, pCode, saleAmount, Selling, Profit);
	}

	@Override
	public Sale selectSaleByNo(Sale sale) {
		String sql = "select orderNo, date, csNo, pCode, saleAmount from sale where orderNo = ?";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, sale.getOrderNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getSale(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertSale(Sale sale) {
		String sql = "insert into sale values (?, ?, ?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, sale.getOrderNo());
			pstmt.setString(2, sale.getDate());
			pstmt.setInt(3, sale.getCsNo().getCsNo());
			pstmt.setString(4, sale.getpCode().getpCode());
			pstmt.setInt(5, sale.getSaleAmount());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateSale(Sale sale) {
		String sql = "update sale set saleAmount = ? where orderNo = ?";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, sale.getSaleAmount());
			pstmt.setInt(2, sale.getOrderNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteSale(int orderNo) {
		String sql = "delete from sale where orderNo =?";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, orderNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override // 날짜별 조회
	public List<Sale> selectViewByDate(Sale sale) {
		String sql = "select date, csNo, csName, phoneNo, pCode, saleAmount, selling from vw_full_sale where date = ?";
		try (Connection con = JdbcUtil.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, sale.getDate());	
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					List<Sale> list = new ArrayList<Sale>();
					do {
						list.add(getSale(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Sale> selectViewByProduct() {
		String sql = "select date, pCode, pName, saleAmount, price, selling, profit from vw_full_sale";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Sale> list = new ArrayList<Sale>();
				do {
					list.add(getSale(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sale> selectViewByDetail() {
		String sql = "select date, pCode, pName, csName, saleAmount, price, selling, profit from vw_full_sale";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Sale> list = new ArrayList<Sale>();
				do {
					list.add(getSale(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sale> selectViewAll() {
		String sql = "select date, csNo, csName, phoneNo, pCode, saleAmount, selling from vw_full_sale";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Sale> list = new ArrayList<Sale>();
				do {
					list.add(getSale(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}// end of class
