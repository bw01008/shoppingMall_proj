package shoppingMall_proj.SearchPanel;

import java.awt.Font;
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
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

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
		
		JPanel pRight = new JPanel();
		add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel pRightLeft = new JPanel();
		pRight.add(pRightLeft);
		
		btnProduct = new JButton("제품별 조회");
		btnProduct.addActionListener(this);
		pRightLeft.setLayout(new GridLayout(0, 3, 10, 10));
		pRightLeft.add(btnProduct);
		
		btnDetail = new JButton("상세조회");
		btnDetail.addActionListener(this);
		pRightLeft.add(btnDetail);
		
		btnSummary = new JButton("Summary");
		btnSummary.addActionListener(this);
		pRightLeft.add(btnSummary);
		
		JPanel pRightBottom = new JPanel();
		pRight.add(pRightBottom);
		pRightBottom.setLayout(new GridLayout(0, 3, 10, 10));
		
		JLabel lblDate = new JLabel("날짜별 조회");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		pRightBottom.add(lblDate);
		
		dateChooser = new JDateChooser(new Date());
		pRightBottom.add(dateChooser);
		
		JPanel panel = new JPanel();
		pRightBottom.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnSearch = new JButton("검색");
		panel.add(btnSearch);
		btnSearch.addActionListener(this);
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













