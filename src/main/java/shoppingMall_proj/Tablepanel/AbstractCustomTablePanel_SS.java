package shoppingMall_proj.Tablepanel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import shoppingMall_proj.dto.Sale;
import shoppingMall_proj.service.SaleService;


@SuppressWarnings("serial")
public abstract class AbstractCustomTablePanel_SS<T> extends JPanel {

	protected JTable table;
	protected SaleService service;
	protected List<T> list;

	public AbstractCustomTablePanel_SS() {
		initialize();
	}
	
	public void loadData() {
		//service객체를 통해 넘어온 데이터 리스트를 가져온다.
		initList();
		//넘어온 리스트의 사이즈만큼의 배열을 생성, 리스트에 담긴 데이터를 2차배열에 담은 후, 컬럼이름과 함께 모델로 만들어서 테이블에 달아준다
		setList();
	}

	public abstract void initList();

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel()); // getModel로 빼기
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}
	
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}// end of getModel()

	public Object[][] getData() {
		return new Object[][] { {null, null, null, null, null, null, null}, };

	}// end of getData()

	public abstract String[] getColumnNames();

	public abstract void setList();
//		Object[][] data = new Object[list.size()][];
//		
//		for (int i = 0; i < data.length; i++) {
//			data[i] = toArray(list.get(i));
//		}
//		
//		CustomTableModel model = new CustomTableModel(data, getColumnNames());
//		table.setModel(model);
		
	

	public abstract Object[] toArray(T t);

	protected class CustomTableModel extends DefaultTableModel {

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}
}
