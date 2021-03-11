package shoppingMall_proj.UISale;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shoppingMall_proj.Salepanel.SBP.SearchByProduct_ResultPanel;
import shoppingMall_proj.Salepanel.SBP.SearchByProduct_TablePanel;
import shoppingMall_proj.Salepanel.SBP.SearchByProduct_searchPanel;

@SuppressWarnings("serial")
public class SearchByProduct_Main extends JFrame {

	private JPanel contentPane;

	public SearchByProduct_Main() {
		initialize();
	}
	private void initialize() {
		setTitle("제품별 조회");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		
		SearchByProduct_searchPanel pNorth = new SearchByProduct_searchPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		SearchByProduct_TablePanel pCenter = new SearchByProduct_TablePanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		SearchByProduct_ResultPanel pSouth = new SearchByProduct_ResultPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
	}

}
