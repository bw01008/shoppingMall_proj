package shoppingMall_proj.Tablepanel;

import shoppingMall_proj.dto.Sale;
import shoppingMall_proj.service.SaleService;

@SuppressWarnings("serial")
public class SaleTablePanel extends AbstractCustomTablePanel_SS<Sale> {
	private SaleService service;

	@Override
	public String[] getColumnNames() {
		return new String[] { "날짜", "회원번호", "회원명", "휴대전화", "제품코드", "주문수량", "판매액" };
	}

	@Override
	public Object[] toArray(Sale t) {

		return new String[] {
				t.getDate(), 
				String.valueOf(t.getCsNo().getCsNo()),
				String.valueOf(t.getCsNo().getCsName()), 
				String.valueOf(t.getCsNo().getPhoneNo()),
				String.valueOf(t.getpCode().getpCode()), 
				(t.getSaleAmount() + ""), 
				(t.getSelling() + "")

		};
	}

	@Override
	public void initList() {
		list = service.showSaleMainView();
	}
	
	@Override
	public void setList() {
		Object[][] data = new Object[list.size()][];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(list.get(i));
		}
		
		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);
		
	}

	public void setService(SaleService service) {
		this.service = service;
	}

	

}
