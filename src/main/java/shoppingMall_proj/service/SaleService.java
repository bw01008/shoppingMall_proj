package shoppingMall_proj.service;

import java.util.List;

import shoppingMall_proj.dao.SaleDao;
import shoppingMall_proj.dao.Impl.SaleDaoImpl;
import shoppingMall_proj.dto.Sale;

public class SaleService {
	private SaleDao dao  = SaleDaoImpl.getInstance();
	//날짜별조회
	public List<Sale> showSaleMainView(){
		return dao.selectViewAll();
	}
	//제품별조회
	public List<Sale> showSaleProductView(){
		return dao.selectViewByProduct();
	}
	//상세조회
	public List<Sale> showSaleDetileView(){
		return dao.selectViewByDetail();
	}
}
