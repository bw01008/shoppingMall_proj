package shoppingMall_proj.panel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import shoppingMall_proj.UI.SaleMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel implements ActionListener {
	private JButton btnSale;

	/**
	 * Create the panel.
	 */
	public MainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pNorth = new JPanel();
		add(pNorth);
		
		JPanel pCenter = new JPanel();
		add(pCenter);
		pCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));
		
		JButton btnCustomer = new JButton("회원 관리");
		btnCustomer.setHorizontalAlignment(SwingConstants.LEADING);
		pCenter.add(btnCustomer);
		
		JButton btnProduct = new JButton("제품 관리");
		btnProduct.setHorizontalAlignment(SwingConstants.LEADING);
		pCenter.add(btnProduct);
		
		btnSale = new JButton("판매 관리");
		btnSale.addActionListener(this);
		btnSale.setHorizontalAlignment(SwingConstants.LEADING);
		pCenter.add(btnSale);
		
		JPanel pSouth = new JPanel();
		add(pSouth);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSale) {
			actionPerformedBtnSale(arg0);
		}
	}
	protected void actionPerformedBtnSale(ActionEvent arg0) {
		SaleMain frame = new SaleMain();
		frame.setVisible(true);
	}
}
