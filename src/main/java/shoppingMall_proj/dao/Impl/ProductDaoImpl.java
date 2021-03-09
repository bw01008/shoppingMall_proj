package shoppingMall_proj.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import shoppingMall_proj.dao.ProductDao;
import shoppingMall_proj.dto.Product;
import shoppingMall_proj.dto.util.JdbcUtil;

public class ProductDaoImpl implements ProductDao {
	private static ProductDaoImpl instance = new ProductDaoImpl();
	
	private ProductDaoImpl() {
	}
	
	public static ProductDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Product> selectProductByAll() {
		String sql = "select pCode, pName, price, stockAmount from product";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Product> list = new ArrayList<Product>();
				do {
					list.add(getProduct(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		String pCode = rs.getString("pCode");
		String pName = rs.getString("pName");
		int price = rs.getInt("price");
		int stockAmount = rs.getInt("stockAmount");
		return new Product(pCode, pName, price, stockAmount);
	}

	@Override
	public Product selectProductByNo(Product p) {
		String sql = "select pCode, pName, price, stockAmount from product where pCode =?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, p.getpCode());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getProduct(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertProduct(Product p) {
		String sql = "insert into product values(?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, p.getpCode());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setInt(4, p.getStockAmount());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateProduct(Product p) {
		String sql = "update product set price = ? where pCode = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, p.getPrice());
			pstmt.setString(2, p.getpCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteProduct(String pcode) {
		String sql = "delete from product where pCode = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, pcode);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
