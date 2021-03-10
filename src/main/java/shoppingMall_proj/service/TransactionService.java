package shoppingMall_proj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import shoppingMall_proj.dto.Product;
import shoppingMall_proj.dto.Sale;
import shoppingMall_proj.dto.util.JdbcUtil;

//구매시, 판매수량은 ++, 재고수량은 -- update 테스트
public class TransactionService {

	public String TransUpdateProductAndSale(Product p, Sale s) {
		String productSql = "update product set stockAmount = ? where pCode = (select pCode from sale where orderNo = ?)";	
		String saleSql = "update sale set saleAmount = ? where orderNo = ?";
		Connection con = null;
		PreparedStatement pPstmt = null;
		PreparedStatement sPstmt = null;
		String res = null;
		int sa;
		
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			pPstmt = con.prepareStatement(productSql);
			pPstmt.setInt(1, p.getStockAmount());
			pPstmt.setInt(2, s.getOrderNo());
			
			sPstmt = con.prepareStatement(saleSql);
			sPstmt.setInt(1, s.getSaleAmount());
			sPstmt.setInt(2, s.getOrderNo());
			
			con.commit();
			res = "commit";
		} catch (SQLException e) {
			res = "rollback";
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			System.out.println(res);
			try {
				con.setAutoCommit(true); // 다 끝나면 오토커밋을 다시 켜준다.
				if (pPstmt != null)
					pPstmt.close();
				if (sPstmt != null)
					sPstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return null;
	}
}
