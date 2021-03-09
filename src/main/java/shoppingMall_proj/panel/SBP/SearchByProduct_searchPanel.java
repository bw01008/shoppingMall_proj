package shoppingMall_proj.panel.SBP;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchByProduct_searchPanel extends JPanel {
	private JTextField tfSearch;

	/**
	 * Create the panel.
	 */
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
		
		JComboBox cmbType = new JComboBox();
		pSearch.add(cmbType);
		
		tfSearch = new JTextField();
		pSearch.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		pSearch.add(btnSearch);
		
		JButton btnInitialize = new JButton("초기화");
		pSearch.add(btnInitialize);
	}

}
