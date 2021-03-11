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
		String date = rs.getString("date");
		Customer csNo = new Customer(rs.getInt("csNo"));
		Product pCode = new Product(rs.getString("pCode"));
		int saleAmount = rs.getInt("saleAmount");
		
		try {
			orderNo = rs.getInt("orderNo");
		} catch (SQLException e) {
		}
		try {
			csNo.setCsName(rs.getString("csName"));
		} catch (SQLException e) {
		}
		try {
			csNo.setBirth(rs.getString("birth"));
		} catch (SQLException e) {
		}
		try {
			csNo.setPhoneNo(rs.getString("phoneNo"));
		} catch (SQLException e) {
		}
		try {
			csNo.setSex(rs.getInt("sex"));
		} catch (SQLException e) {
		}
		try {
			pCode.setpName(rs.getString("pName"));
		} catch (SQLException e) {
		}
		try {
			pCode.setPrice(rs.getInt("price"));
		} catch (SQLException e) {
		}
		try {
			pCode.setStockAmount(rs.getInt("stockAmount"));
		} catch (SQLException e) {
		}

		return new Sale(orderNo, date, csNo, pCode, saleAmount);
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

}// end of class
