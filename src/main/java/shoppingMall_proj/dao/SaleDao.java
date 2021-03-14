package shoppingMall_proj.dao;

import java.util.List;

import shoppingMall_proj.dto.Sale;

public interface SaleDao {
	//selectall 추상메서드 - 모든 데이터를 리스트에 담아서 받아온다
	List<Sale> selectSaleByAll();
	//select by 추상메서드 - 기본키로 검색 > 조회결과 1개를 객체로 받아온다
	Sale selectSaleByNo(Sale sale);
	// insert 추상메서드
	int insertSale(Sale sale);
	// update 추상메서드
	int updateSale(Sale sale);
	// delete 추상메서드
	int deleteSale(int orderNo);
	
	List<Sale> selectViewByDate(Sale sale);
	List<Sale> selectViewByProduct();
	List<Sale> selectViewByDetail();
	
	List<Sale> selectViewAll();
}
