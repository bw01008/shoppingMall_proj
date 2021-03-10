package shoppingMall_proj.UI;

import java.awt.BorderLayout;
import java.sql.Date;
import java.util.List;

import javax.swing.JPanel;

import shoppingMall_proj.dao.Impl.SaleDaoImpl;
import shoppingMall_proj.dto.Sale;
import shoppingMall_proj.panel.SaleMain_ResultPanel;
import shoppingMall_proj.panel.SaleMain_SearchPanel;
import shoppingMall_proj.panel.SaleMain_TablePanel;

public class Sale_Main extends JPanel {
	private List<Sale> saleList = SaleDaoImpl.getInstance().selectViewByDate(new Sale(new Date(2012, 04, 12)));
	
	
	
	public Sale_Main() {
		
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		SaleMain_SearchPanel pNorth = new SaleMain_SearchPanel();	//몹핑
		add(pNorth, BorderLayout.NORTH);
		//////////////////List추가
		SaleMain_TablePanel pCenter = new SaleMain_TablePanel();	//몹핑
		pCenter.setList(saleList);
		add(pCenter, BorderLayout.CENTER);
		
		SaleMain_ResultPanel pSouth = new SaleMain_ResultPanel();	//몹핑
		add(pSouth, BorderLayout.SOUTH);
		
		
	}

}
