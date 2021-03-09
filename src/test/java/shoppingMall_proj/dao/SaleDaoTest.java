package shoppingMall_proj.dao;


import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shoppingMall_proj.dao.Impl.SaleDaoImpl;
import shoppingMall_proj.dto.Customer;
import shoppingMall_proj.dto.Product;
import shoppingMall_proj.dto.Sale;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest {
	private static SaleDao dao = SaleDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test05SelectSaleByAll() {
		System.out.printf("%s()%n","test05SelectSaleByAll");
		List<Sale> saleList = dao.selectSaleByAll();
		Assert.assertNotNull(saleList);
		
		for(Sale a : saleList) {
			System.out.println(a);
		}
	}

	@Test
	public void test04SelectSaleByNo() {
		System.out.printf("%s()%n","test04SelectSaleByNo");
		Sale sale = new Sale(1);
		Sale searchSale = dao.selectSaleByNo(sale);
		Assert.assertNotNull(searchSale);
		System.out.println(searchSale);
	}

	@Test
	public void test01InsertSale() {
		System.out.printf("%s()%n","test01InsertSale");
		Sale newSale = new Sale(17, new Date(20120502), new Customer(12007), new Product("PA"), 1);
		int res = dao.insertSale(newSale);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectSaleByNo(newSale));
	}

	@Test
	public void test02UpdateSale() {
		System.out.printf("%s()%n","test02UpdateSale");
		Sale newSale = new Sale(17, new Date(20120502), new Customer(12007), new Product("PA"), 2);
		int res = dao.updateSale(newSale);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectSaleByNo(newSale));
	}

	@Test
	public void test03DeleteSale() {
		System.out.printf("%s()%n","test03DeleteSale");
		int res = dao.deleteSale(17);
		Assert.assertEquals(1, res);
//		dao.selectSaleByAll().stream().forEach(System.out::println);
	}

}
