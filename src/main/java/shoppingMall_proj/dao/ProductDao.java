package shoppingMall_proj.dao;

import java.util.List;

import shoppingMall_proj.dto.Product;

public interface ProductDao {
	//selectall 추상메서드 - 모든 데이터를 리스트에 담아서 받아온다
	List<Product> selectProductByAll();
	//select by 추상메서드 - 기본키로 검색 > 조회결과 1개를 객체로 받아온다
	Product selectProductByNo(Product p);
	// insert 추상메서드
	int insertProduct(Product p);
	// update 추상메서드
	int updateProduct(Product p);
	// delete 추상메서드
	int deleteProduct(int pcode);
}
