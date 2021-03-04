package shoppingMall_proj.dao;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shoppingMall_proj.dao.Impl.CustomerDaoImpl;
import shoppingMall_proj.dto.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoTest {
	private static CustomerDao dao = CustomerDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectCustomerByAll() {
		System.out.printf("%s()%n", "test01SelectCustomerByAll");
		List<Customer> csList = dao.selectCustomerByAll();
		Assert.assertNotNull(csList);

		for (Customer c : csList) {
			System.out.println(c);
		}

	}

	@Test
	public void test02SelectCustomerByNo() {
		System.out.printf("%s()%n", "test02SelectCustomerByNo");
		Customer cs = new Customer(12001);
		Customer searchCustomer = dao.selectCustomerByNo(cs);
		Assert.assertNotNull(searchCustomer);
		System.out.println(searchCustomer);
	}

	@Test
	public void test03InsertCustomer() {
		System.out.printf("%s()%n", "test03InsertCustomer");
		Customer newCustomer = new Customer(12011, "우정아", new Date(19931108), "01077731663", 0);
		int res = dao.insertCustomer(newCustomer);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectCustomerByNo(newCustomer));
		
	}

	@Test
	public void test04UpdateCustomer() {
		System.out.printf("%s()%n", "test04UpdateCustomer");
		Customer newCustomer = new Customer(12011, "우정아", new Date(19931108), "01077731663", 1);
		int res = dao.updateCustomer(newCustomer);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectCustomerByNo(newCustomer));
	}

	@Test
	public void test05DeleteCustomer() {
		System.out.printf("%s()%n", "test05DeleteCustomer");
		int res = dao.deleteCustomer(12011);
		Assert.assertEquals(1, res);
		dao.selectCustomerByAll().stream().forEach(System.out::println);
	}

}
