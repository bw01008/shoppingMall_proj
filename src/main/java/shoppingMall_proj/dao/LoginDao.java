package shoppingMall_proj.dao;

import java.util.List;

import shoppingMall_proj.dto.Login;
import shoppingMall_proj.dto.Product;

public interface LoginDao {
	//selectall 추상메서드 - 모든 데이터를 리스트에 담아서 받아온다
		List<Login> selectProductByAll();
		//select by 추상메서드 - 기본키로 검색 > 조회결과 1개를 객체로 받아온다
		Product selectProductByNo(Login log);
		// insert 추상메서드
		int insertProduct(Login log);
		// update 추상메서드
		int updateProduct(Login log);
		// delete 추상메서드
		int deleteProduct(String ID);
}
