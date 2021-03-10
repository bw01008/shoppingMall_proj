package shoppingMall_proj.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import shoppingMall_proj.UI.SearchByDetail_Main;
import shoppingMall_proj.UI.SearchByProduct_Main;

@SuppressWarnings("serial")
public class SaleMain_SearchPanel extends JPanel implements ActionListener {
	private JButton btnProduct;
	private JButton btnDetail;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public SaleMain_SearchPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pBtns = new JPanel();
		add(pBtns);

		btnProduct = new JButton("제품별 조회");
		btnProduct.addActionListener(this);
		pBtns.add(btnProduct);

		btnDetail = new JButton("상세조회");
		btnDetail.addActionListener(this);
		pBtns.add(btnDetail);

		JPanel psearchDate = new JPanel();
		add(psearchDate);

		JLabel lblDate = new JLabel("날짜별 조회");
		psearchDate.add(lblDate);

		JDateChooser dateChooser = new JDateChooser();
		psearchDate.add(dateChooser);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		psearchDate.add(btnSearch);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSearch) {
			actionPerformedBtnSearch(arg0);
		}
		if (arg0.getSource() == btnDetail) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == btnProduct) {
			actionPerformedButton(arg0);
		}
	}

	protected void actionPerformedButton(ActionEvent arg0) {
		SearchByProduct_Main frame = new SearchByProduct_Main();
		frame.setVisible(true);
	}

	protected void actionPerformedButton_1(ActionEvent arg0) {
		SearchByDetail_Main frame = new SearchByDetail_Main();
		frame.setVisible(true);
	}
	//날짜별 조회 검색 > 
	protected void actionPerformedBtnSearch(ActionEvent arg0) {
		
	}
}
