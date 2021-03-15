package shoppingMall_proj.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoppingMall_proj.dao.LoginDao;
import shoppingMall_proj.dto.Login;
import shoppingMall_proj.dto.util.JdbcUtil;

public class LoginDaoImpl implements LoginDao {
	
	private static LoginDaoImpl instance = new LoginDaoImpl();
	
	private LoginDaoImpl() {
		
	}
	
	public static LoginDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Login> selectLoginByAll() {
		String sql = "select ID, password from login";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Login> list = new ArrayList<Login>();
				do {
					list.add(getLogin(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Login getLogin(ResultSet rs) throws SQLException {
		String ID = rs.getString("ID");
		String password = rs.getString("password");
		return new Login(ID, password);
	}

	@Override
	public Login selectLoginByID(Login log) {
		String sql = "select ID, password from login where ID = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, log.getID());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getLogin(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insertLogin(Login log) {
		String sql = "insert into login values(?, ?)";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, log.getID());
			pstmt.setString(2, log.getPassword());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateLogin(Login log) {
		String sql = "update login set password = ? where id = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, log.getPassword());
			pstmt.setNString(2, log.getID());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteLogin(String ID) {
		return 0;
	}

}
