package shoppingMall_proj.UISale;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import shoppingMall_proj.ResultPanel.SaleMain_ResultPanel;
import shoppingMall_proj.SearchPanel.SaleMain_SearchPanel;
import shoppingMall_proj.Tablepanel.SaleTablePanel;
import shoppingMall_proj.service.SaleService;

@SuppressWarnings("serial")
public class SaleMainPanel extends JPanel {
	
	public SaleService service;	//세일서비스 객체 생성해놓고 하위패널들이 접근할 수 있도록 해준다.
	
	public SaleMainPanel() {
		service = new SaleService();
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		SaleMain_SearchPanel pNorth = new SaleMain_SearchPanel();
		add(pNorth, BorderLayout.NORTH);
		
		SaleTablePanel pCenter = new SaleTablePanel();	//테이블
		add(pCenter, BorderLayout.CENTER);
		pCenter.setService(service);
		pCenter.loadData();
		
		SaleMain_ResultPanel pSouth = new SaleMain_ResultPanel();
		add(pSouth, BorderLayout.SOUTH);
	}

}
