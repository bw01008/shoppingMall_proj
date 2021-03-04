package shoppingMall_proj.dao;

import java.util.List;

import shoppingMall_proj.dto.Customer;


public interface CustomerDao {
		//selectall 추상메서드 - 모든 데이터를 리스트에 담아서 받아온다
		List<Customer> selectCustomerByAll();
		//select by 추상메서드 - 기본키로 검색 > 조회결과 1개를 객체로 받아온다
		Customer selectCustomerByNo(Customer cs);
		// insert 추상메서드
		int insertCustomer(Customer cs);
		// update 추상메서드
		int updateCustomer(Customer cs);
		// delete 추상메서드
		int deleteCustomer(int csNo);
		

}
