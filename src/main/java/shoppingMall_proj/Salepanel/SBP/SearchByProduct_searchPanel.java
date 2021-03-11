package shoppingMall_proj.Salepanel.SBP;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SearchByProduct_searchPanel extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnInitialize;
	private JComboBox cmbType;

	public SearchByProduct_searchPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pTitle = new JPanel();
		add(pTitle);
		
		JLabel lblTitle = new JLabel("제품별 조회");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 40));
		pTitle.add(lblTitle);
		
		JPanel pSearch = new JPanel();
		add(pSearch);
		
		JLabel lblSearch = new JLabel("검색조건");
		pSearch.add(lblSearch);
		
		cmbType = new JComboBox();
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"제품코드", "제품명"}));
		pSearch.add(cmbType);
		
		tfSearch = new JTextField();
		pSearch.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pSearch.add(btnSearch);
		
		btnInitialize = new JButton("초기화");
		btnInitialize.addActionListener(this);
		pSearch.add(btnInitialize);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInitialize) {
			actionPerformedBtnInitialize(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}
	//검색버튼
	protected void actionPerformedBtnSearch(ActionEvent e) {
	}
	
	//초기화버튼
	protected void actionPerformedBtnInitialize(ActionEvent e) {
		tfSearch.setText("");
		//cmbType.set // > 콤보박스 초기화(빈칸 혹은 제품코드로 디폴트 두기)
	}
}
