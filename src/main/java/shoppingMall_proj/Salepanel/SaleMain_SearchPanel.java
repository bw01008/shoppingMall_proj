package shoppingMall_proj.Salepanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import shoppingMall_proj.UISale.SearchByDetail_Main;
import shoppingMall_proj.UISale.SearchByProduct_Main;
import shoppingMall_proj.UISale.Summary_Main;

import java.awt.Font;

@SuppressWarnings("serial")
public class SaleMain_SearchPanel extends JPanel implements ActionListener {
	private JButton btnProduct;
	private JButton btnDetail;
	private JButton btnSummary;
	private JButton btnSearch;
	private JDateChooser dateChooser;

	/**
	 * Create the panel.
	 */
	public SaleMain_SearchPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pLeft = new JPanel();
		add(pLeft);
		
		JLabel lblTitle = new JLabel("일별 판매관리");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		pLeft.add(lblTitle);
		
		JPanel pRightTop = new JPanel();
		add(pRightTop);
		pRightTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		pRightTop.add(panel_2);
		
		btnProduct = new JButton("제품별 조회");
		btnProduct.addActionListener(this);
		panel_2.add(btnProduct);
		
		btnDetail = new JButton("상세조회");
		btnDetail.addActionListener(this);
		panel_2.add(btnDetail);
		
		btnSummary = new JButton("Summary");
		btnSummary.addActionListener(this);
		panel_2.add(btnSummary);
		
		JPanel pRightBottom = new JPanel();
		pRightTop.add(pRightBottom);
		
		JLabel lblDate = new JLabel("날짜별 조회");
		pRightBottom.add(lblDate);
		
		dateChooser = new JDateChooser();
		pRightBottom.add(dateChooser);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pRightBottom.add(btnSearch);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSearch) {
			actionPerformedBtnSearch(arg0);
		}
		if (arg0.getSource() == btnSummary) {
			actionPerformedBtnSummary(arg0);
		}
		if (arg0.getSource() == btnDetail) {
			actionPerformedBtnDetail(arg0);
		}
		if (arg0.getSource() == btnProduct) {
			actionPerformedBtnProduct(arg0);
		}
	}
	protected void actionPerformedBtnProduct(ActionEvent arg0) {
		SearchByProduct_Main frame = new SearchByProduct_Main();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnDetail(ActionEvent arg0) {
		SearchByDetail_Main frame = new SearchByDetail_Main();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnSummary(ActionEvent arg0) {
		Summary_Main frame = new Summary_Main();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnSearch(ActionEvent arg0) {
		Date res = dateChooser.getDate();
		
	}
}













