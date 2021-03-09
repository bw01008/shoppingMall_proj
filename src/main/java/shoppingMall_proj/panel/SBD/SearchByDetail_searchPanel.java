package shoppingMall_proj.panel.SBD;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchByDetail_searchPanel extends JPanel {
	private JTextField tfProduct;
	private JTextField tfCustomer;

	/**
	 * Create the panel.
	 */
	public SearchByDetail_searchPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		add(pLeft);
		
		JLabel lblTitle = new JLabel("상세 조회");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 40));
		pLeft.add(lblTitle);
		
		JPanel pRight = new JPanel();
		add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pRightTop = new JPanel();
		pRight.add(pRightTop);
		
		JLabel lblProduct = new JLabel("제품별 검색");
		pRightTop.add(lblProduct);
		
		JComboBox cmbProduct = new JComboBox();
		pRightTop.add(cmbProduct);
		
		tfProduct = new JTextField();
		pRightTop.add(tfProduct);
		tfProduct.setColumns(10);
		
		JButton btnSearchP = new JButton("검색");
		pRightTop.add(btnSearchP);
		
		JPanel pRightBottom = new JPanel();
		pRight.add(pRightBottom);
		
		JLabel lblCustomer = new JLabel("회원별 검색");
		pRightBottom.add(lblCustomer);
		
		JComboBox cmbCustomer = new JComboBox();
		pRightBottom.add(cmbCustomer);
		
		tfCustomer = new JTextField();
		pRightBottom.add(tfCustomer);
		tfCustomer.setColumns(10);
		
		JButton btnSearchC = new JButton("검색");
		pRightBottom.add(btnSearchC);
	}

}
