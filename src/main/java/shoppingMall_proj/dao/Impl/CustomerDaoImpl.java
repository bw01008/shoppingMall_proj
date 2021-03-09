package shoppingMall_proj.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoppingMall_proj.dao.CustomerDao;
import shoppingMall_proj.dto.Customer;
import shoppingMall_proj.dto.util.JdbcUtil;

public class CustomerDaoImpl implements CustomerDao {
	// 싱글톤 객체 생성
	private static CustomerDaoImpl instance = new CustomerDaoImpl();

	// 외부객체 생성이 불가하도록 private으로 기본생성자
	private CustomerDaoImpl() {
	}

	// getter
	public static CustomerDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Customer> selectCustomerByAll() {
		String sql = "select csNo, csName, birth, phoneNo, sex from customer";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Customer> list = new ArrayList<Customer>();
				do {
					list.add(getCustomer(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Customer getCustomer(ResultSet rs) throws SQLException {
		int csNo = rs.getInt("csNo");
		String csName = rs.getString("csName");
		Date birth = rs.getDate("birth");
		String phoneNo = rs.getString("phoneNo");
		int sex = rs.getInt("sex");
		return new Customer(csNo, csName, birth, phoneNo, sex);
	}

	@Override
	public Customer selectCustomerByNo(Customer cs) {
		String sql = "select csNo, csName, birth, phoneNo, sex from customer where csNo = ?";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, cs.getCsNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getCustomer(rs);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertCustomer(Customer cs) {
		String sql = "insert into customer values(?, ?, ?, ?, ?)";
		try (Connection con = JdbcUtil.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, cs.getCsNo());
			pstmt.setString(2, cs.getCsName());
			pstmt.setDate(3, cs.getBirth());
			pstmt.setNString(4, cs.getPhoneNo());
			pstmt.setInt(5, cs.getSex());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomer(Customer cs) {
		String sql = "update customer set sex = ? where csNo = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, cs.getSex());
			pstmt.setInt(2, cs.getCsNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCustomer(int csNo) {
		String sql = "delete from customer where csNo = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, csNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
