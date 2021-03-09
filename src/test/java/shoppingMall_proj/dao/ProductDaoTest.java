package shoppingMall_proj.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import shoppingMall_proj.dao.Impl.ProductDaoImpl;
import shoppingMall_proj.dto.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {
	private static ProductDao dao = ProductDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test05SelectProductByAll() {
		System.out.printf("%s()%n", "test05SelectProductByAll");
		List<Product> pList = dao.selectProductByAll();
		Assert.assertNotNull(pList);

		for (Product a : pList) {
			System.out.println(a);
		}
	}

	@Test
	public void test04SelectProductByNo() {
		System.out.printf("%s()%n", "test04SelectProductByNo");
		Product p = new Product("PA");
		Product searchP = dao.selectProductByNo(p);
		Assert.assertNotNull(searchP);
		System.out.println(dao.selectProductByNo(searchP));
	}

	@Test
	public void test01InsertProduct() {
		System.out.printf("%s()%n", "test01InsertProduct");
		Product newP = new Product("PI", "아이패드", 50000, 100);
		int res = dao.insertProduct(newP);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectProductByNo(newP));
	}

	@Test
	public void test02UpdateProduct() {
		System.out.printf("%s()%n", "test02UpdateProduct");
		Product newP = new Product("PI", "아이패드", 100000, 100);
		int res = dao.updateProduct(newP);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectProductByNo(newP));
	}

	@Test
	public void test03DeleteProduct() {
		System.out.printf("%s()%n", "test03DeleteProduct");
		int res = dao.deleteProduct("PI");
		Assert.assertEquals(1, res);
		dao.selectProductByAll().stream().forEach(System.out::println);
	}

}
