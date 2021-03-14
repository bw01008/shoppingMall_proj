package shoppingMall_proj.UISale;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shoppingMall_proj.ResultPanel.SearchByProduct_ResultPanel;
import shoppingMall_proj.SearchPanel.SearchByProduct_searchPanel;
import shoppingMall_proj.Tablepanel.SaleByProductTablePanel;
import shoppingMall_proj.service.SaleService;

@SuppressWarnings("serial")
public class SearchByProduct_Main extends JFrame {

	private JPanel contentPane;
	private SaleService service;

	public SearchByProduct_Main() {
		service = new SaleService();
		initialize();
	}
	private void initialize() {
		setTitle("제품별 조회");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		
		SearchByProduct_searchPanel pNorth = new SearchByProduct_searchPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		SaleByProductTablePanel pCenter = new SaleByProductTablePanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setService(service);
		pCenter.loadData();
		
		
		SearchByProduct_ResultPanel pSouth = new SearchByProduct_ResultPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
	}

}
