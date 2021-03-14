package shoppingMall_proj.UISale;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shoppingMall_proj.ResultPanel.SearchByDetail_ResultPanel;
import shoppingMall_proj.SearchPanel.SearchByDetail_searchPanel;
import shoppingMall_proj.service.SaleService;
import shoppingMall_proj.Tablepanel.SaleByDetailTablePanel;

@SuppressWarnings("serial")
public class SearchByDetail_Main extends JFrame {

	private JPanel contentPane;
	private SaleService service;
	
	public SearchByDetail_Main() {
		service = new SaleService();
		initialize();
	}
	private void initialize() {
		setTitle("상세 조회");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SearchByDetail_searchPanel pNorth = new SearchByDetail_searchPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		

		SearchByDetail_ResultPanel pSouth = new SearchByDetail_ResultPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		SaleByDetailTablePanel pCenter = new SaleByDetailTablePanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setService(service);
		pCenter.loadData();
	}

}
