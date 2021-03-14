package shoppingMall_proj.SearchPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchByDetail_searchPanel extends JPanel implements ActionListener {
	private JTextField tfProduct;
	private JTextField tfCustomer;
	private JButton btnSearchP;
	private JButton btnSearchC;

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
		cmbProduct.setModel(new DefaultComboBoxModel(new String[] {"제품코드", "제품명"}));
		pRightTop.add(cmbProduct);
		
		tfProduct = new JTextField();
		pRightTop.add(tfProduct);
		tfProduct.setColumns(10);
		
		btnSearchP = new JButton("검색");
		btnSearchP.addActionListener(this);
		pRightTop.add(btnSearchP);
		
		JPanel pRightBottom = new JPanel();
		pRight.add(pRightBottom); 
		
		JLabel lblCustomer = new JLabel("회원별 검색");
		pRightBottom.add(lblCustomer);
		
		JComboBox cmbCustomer = new JComboBox();
		cmbCustomer.setModel(new DefaultComboBoxModel(new String[] {"회원 이름", "회원 번호"}));
		pRightBottom.add(cmbCustomer);
		
		tfCustomer = new JTextField();
		pRightBottom.add(tfCustomer);
		tfCustomer.setColumns(10);
		
		btnSearchC = new JButton("검색");
		btnSearchC.addActionListener(this);
		pRightBottom.add(btnSearchC);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearchC) {
			actionPerformedBtnSearchC(e);
		}
		if (e.getSource() == btnSearchP) {
			actionPerformedBtnSearchP(e);
		}
	}
	//검색버튼 - 제품별
	protected void actionPerformedBtnSearchP(ActionEvent e) {
	}
	//검색버튼 - 회원별
	protected void actionPerformedBtnSearchC(ActionEvent e) {
	}
}
