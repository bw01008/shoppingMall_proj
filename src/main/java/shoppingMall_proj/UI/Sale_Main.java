package shoppingMall_proj.UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import shoppingMall_proj.panel.SaleMain_SearchPanel;
import shoppingMall_proj.panel.SaleMain_TablePanel;
import shoppingMall_proj.panel.SaleMain_ResultPanel;

public class Sale_Main extends JPanel {

	/**
	 * Create the panel.
	 */
	public Sale_Main() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		SaleMain_SearchPanel pNorth = new SaleMain_SearchPanel();
		add(pNorth, BorderLayout.NORTH);
		
		SaleMain_TablePanel pCenter = new SaleMain_TablePanel();
		add(pCenter, BorderLayout.CENTER);
		
		SaleMain_ResultPanel pSouth = new SaleMain_ResultPanel();
		add(pSouth, BorderLayout.SOUTH);
	}

}
