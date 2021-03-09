package shoppingMall_proj.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import shoppingMall_proj.panel.SaleMain_SearchPanel;
import shoppingMall_proj.panel.SaleMain_TablePanel;
import shoppingMall_proj.panel.SaleMain_ResultPanel;

public class SaleMain extends JFrame {

	private JPanel contentPane;

	public SaleMain() {
		initialize();
	}
	private void initialize() {
		setTitle("판매 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		SaleMain_SearchPanel pNorth = new SaleMain_SearchPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		SaleMain_TablePanel pCenter = new SaleMain_TablePanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		SaleMain_ResultPanel pSouth = new SaleMain_ResultPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
	}

}
