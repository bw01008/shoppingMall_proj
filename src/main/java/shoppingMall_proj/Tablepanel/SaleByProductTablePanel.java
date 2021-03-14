package shoppingMall_proj.Tablepanel;

import shoppingMall_proj.dto.Sale;
import shoppingMall_proj.service.SaleService;

@SuppressWarnings("serial")
public class SaleByProductTablePanel extends AbstractCustomTablePanel_SS<Sale> {
	private SaleService service;
	
	@Override
	public void initList() {
		list = service.showSaleProductView();
		System.out.println(list);
	}

	@Override
	public String[] getColumnNames() {
		return new String[]{"날짜", "제품코드", "제품명", "주문수량", "단가", "판매액", "이익금액"};
	}

	@Override
	public Object[] toArray(Sale t) {
		return new Object[] {
				t.getDate(),
				String.valueOf(t.getpCode().getpCode()),
				String.valueOf(t.getpCode().getpName()),
				(t.getSaleAmount() + ""),
				String.valueOf(t.getpCode().getPrice()),
				(t.getSelling() + ""),
				(t.getProfit() + "")
		};
	}

	public void setService(SaleService service) {
		this.service = service;
	}

}
