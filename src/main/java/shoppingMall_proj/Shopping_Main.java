package shoppingMall_proj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import shoppingMall_proj.UI.Sale_Main;

@SuppressWarnings("serial")
public class Shopping_Main extends JFrame {

	private JPanel contentPane;


	public Shopping_Main() {
		initialize();
	}
	private void initialize() {
		setTitle("쇼핑몰 관리 프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pCustomer = new JPanel();
		tabbedPane.addTab("고객 관리", null, pCustomer, "고객 관리");
		
		JPanel pProduct = new JPanel();
		tabbedPane.addTab("상품 관리", null, pProduct, "상품 관리");
		
		Sale_Main pSale = new Sale_Main();
		tabbedPane.addTab("판매 관리", null, pSale, "판매 관리");
	}

}
