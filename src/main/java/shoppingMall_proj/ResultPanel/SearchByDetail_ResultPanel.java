package shoppingMall_proj.ResultPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class SearchByDetail_ResultPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SearchByDetail_ResultPanel() {

		initialize();
	}
	private void initialize() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(30);
		flowLayout.setHgap(20);
		
		JLabel lblTotalOrder1 = new JLabel("총 주문 건수");
		add(lblTotalOrder1);
		
		JLabel lblTotalOrder2 = new JLabel("");
		add(lblTotalOrder2);
		
		JLabel lblTotalSaleAmount1 = new JLabel("총 주문 수량");
		add(lblTotalSaleAmount1);
		
		JLabel lblTotalSaleAmount2 = new JLabel("");
		add(lblTotalSaleAmount2);
		
		JLabel lblTotalSelling1 = new JLabel("총 판매액");
		add(lblTotalSelling1);
		
		JLabel lblTotalSelling2 = new JLabel("");
		add(lblTotalSelling2);
		
		JLabel lblTotalProfit1 = new JLabel("총 이익금액");
		add(lblTotalProfit1);
		
		JLabel lblTotalProfit2 = new JLabel("");
		add(lblTotalProfit2);
	}

}
