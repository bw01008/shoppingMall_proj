package shoppingMall_proj.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.GridLayout;

public class SaleMain_ResultPanel extends JPanel {

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
		
		JLabel lblTotalSaleAmount2 = new JLabel("");
		pLeft.add(lblTotalSaleAmount2);
		
		JPanel pRight = new JPanel();
		add(pRight);
		
		JLabel lblTotalSelling1 = new JLabel("총 판매액 : ");
		pRight.add(lblTotalSelling1);
		
		JLabel lblTotalSelling2 = new JLabel("");
		pRight.add(lblTotalSelling2);
	}

}
