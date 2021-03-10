package shoppingMall_proj;

import java.util.List;

import shoppingMall_proj.dao.Impl.SaleDaoImpl;
import shoppingMall_proj.dto.Sale;

public class test {

	public static void main(String[] args) {
		List<Sale> saleList = SaleDaoImpl.getInstance().selectViewByDate(new Sale(20120420));

		for(Sale a : saleList) {
			System.out.println(a);
		}

	}

}
