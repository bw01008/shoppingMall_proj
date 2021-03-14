package shoppingMall_proj.ResultPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import shoppingMall_proj.dto.Sale;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class SaleMain_ResultPanel extends JPanel {

	private JLabel lblTotalSaleAmount2;
	private JLabel lblTotalSelling2;
	/**
	 * Create the panel.
	 */
	public SaleMain_ResultPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		add(pLeft);
		
		JLabel lblTotalSaleAmount1 = new JLabel("총 주문수량 : ");
		pLeft.add(lblTotalSaleAmount1);
		
		lblTotalSaleAmount2 = new JLabel("");
		pLeft.add(lblTotalSaleAmount2);
//		lblTotalSaleAmount2.setText();	- 총 주문 수량 결과
		
		
		JPanel pRight = new JPanel();
		add(pRight);
		
		JLabel lblTotalSelling1 = new JLabel("총 판매액 : ");
		pRight.add(lblTotalSelling1);
		
		lblTotalSelling2 = new JLabel("");
		pRight.add(lblTotalSelling2);
//		lblTotalSelling2.setText();	 - 총 판매액 결과
	}

}
