package shoppingMall_proj.Tablepanel;

import shoppingMall_proj.dto.Sale;
import shoppingMall_proj.service.SaleService;

@SuppressWarnings("serial")
public class SaleByDetailTablePanel extends AbstractCustomTablePanel_SS<Sale> {
	SaleService service;
	
	@Override
	public void initList() {
		list = service.showSaleDetaileView();
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {"번호", "날짜", "제품코드", "제품명", "회원명", "주문수량", "단가", "판매액", "이익금액"};
	}

	@Override
	public Object[] toArray(Sale t) {
		return new Object[] {
				(t.getOrderNo() + ""),
				t.getDate(),
				String.valueOf(t.getpCode().getpCode()),
				String.valueOf(t.getpCode().getpName()),
				String.valueOf(t.getCsNo().getCsName()),
				(t.getSaleAmount() + ""),
				String.valueOf(t.getpCode().getPrice()),
				(t.getSelling() + ""),
				(t.getProfit() + "")
		};
	}
	
	@Override
	public void setList() {
		Object[][] data = new Object[list.size()][];
		int i = 0;
		for (i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}
		
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);
		
	}
	
	public void setService(SaleService service) {
		this.service = service;
		
	}

	
	

}
