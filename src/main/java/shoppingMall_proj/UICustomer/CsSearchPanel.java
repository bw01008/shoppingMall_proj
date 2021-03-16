package shoppingMall_proj.UICustomer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class CsSearchPanel extends JPanel {
	private JTextField tfCsSearch;
	private JTextField tfPnoSearch;

	/**
	 * Create the panel.
	 */
	public CsSearchPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pTop = new JPanel();
		add(pTop);
		
		JLabel lblSearch = new JLabel("회원 검색");
		pTop.add(lblSearch);
		
		JComboBox cmbCS = new JComboBox();
		cmbCS.setModel(new DefaultComboBoxModel(new String[] {"회원명", "회원번호"}));
		pTop.add(cmbCS);
		
		tfCsSearch = new JTextField();
		pTop.add(tfCsSearch);
		tfCsSearch.setColumns(10);
		
		JButton btnSearch = new JButton("검색");
		pTop.add(btnSearch);
		
		JPanel pBottom = new JPanel();
		add(pBottom);
		
		JLabel lblPnoSearch = new JLabel("전화번호로 검색");
		pBottom.add(lblPnoSearch);
		
		tfPnoSearch = new JTextField();
		pBottom.add(tfPnoSearch);
		tfPnoSearch.setColumns(10);
		
		JButton btnSearch2 = new JButton("검색");
		pBottom.add(btnSearch2);
	}

}
