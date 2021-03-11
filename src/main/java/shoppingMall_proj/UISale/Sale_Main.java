package shoppingMall_proj.UISale;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import shoppingMall_proj.Salepanel.SaleMain_SearchPanel;
import shoppingMall_proj.Salepanel.SaleMain_TablePanel;
import shoppingMall_proj.Salepanel.SaleMain_ResultPanel;

public class Sale_Main extends JPanel {

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
