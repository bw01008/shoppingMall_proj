package shoppingMall_proj.panel;

import java.awt.BorderLayout;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import shoppingMall_proj.dao.Impl.SaleDaoImpl;
import shoppingMall_proj.dto.Sale;

@SuppressWarnings("serial")
public class SaleMain_TablePanel extends JPanel {
	private JTable table;

	private List<Sale> saleList = SaleDaoImpl.getInstance().selectViewByDate(new Sale());
	
	
	public SaleMain_TablePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(getModel());	//getModel로 빼기
		scrollPane.setViewportView(table);
	}
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(),getColumnNames());
		return model;
	}// end of getModel()
	
	public Object[][] getData() {
		
		return new Object[][] { null, null, null, null, null, null, null };
	}// end of getData()
	
	public String[] getColumnNames() {
		return new String[] {"날짜", "회원번호", "회원명", "휴대전화", "제품코드", "주문수량", "판매액"};
	}// end of getColumnNames()
	
	public void setList(List<Sale> saleList) {
		
		Object[][] datas = new Object[saleList.size()][];
		for(int i = 0; i < datas.length; i++) {
			datas[i] = toArray(saleList.get(i));
		}
		
		CustomTableModel model = new CustomTableModel(datas, getColumnNames());
		table.setModel(model);
	}
	
	

	private Object[] toArray(Sale sale) {
		Object[] data = new Object[] {
				sale.getDate(),
				sale.getCsNo(),
				sale.getCsNo().getCsName(),
				sale.getCsNo().getPhoneNo(),
				sale.getpCode(),
				sale.getSaleAmount(),
				sale.getSelling()
		};
		return data;
	}



	private class CustomTableModel extends DefaultTableModel{

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return super.isCellEditable(row, column);
		}
		
	}

}// end of class
