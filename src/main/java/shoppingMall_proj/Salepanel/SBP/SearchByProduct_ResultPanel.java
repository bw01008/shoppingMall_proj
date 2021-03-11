package shoppingMall_proj.Salepanel.SBP;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SearchByProduct_ResultPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SearchByProduct_ResultPanel() {

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
		
		JLabel lblTotalProfit1 = new JLabel("총 이익금액 : ");
		pRight.add(lblTotalProfit1);
		
		JLabel lblTotalProfit2 = new JLabel("");
		pRight.add(lblTotalProfit2);
	}

}
