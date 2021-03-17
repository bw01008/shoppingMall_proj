package shoppingMall_proj.UICustomer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class CsContentPanel extends JPanel {
	private JTextField tfCsno;
	private JTextField tfCsname;
	private JTextField tfPhoneNo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public CsContentPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pNotth = new JPanel();
		add(pNotth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("회원 추가");
		pNotth.add(lblTitle);
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 4, 10, 10));
		
		JLabel lblCsno = new JLabel("회원번호");
		lblCsno.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblCsno);
		
		tfCsno = new JTextField();
		pCenter.add(tfCsno);
		tfCsno.setColumns(10);
		
		JLabel lblCsName = new JLabel("회원명");
		lblCsName.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblCsName);
		
		tfCsname = new JTextField();
		pCenter.add(tfCsname);
		tfCsname.setColumns(10);
		
		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblBirth);
		
		JDateChooser birthChooser = new JDateChooser(new Date());
		pCenter.add(birthChooser);
		
		JLabel lblPhoneNo = new JLabel("연락처");
		lblPhoneNo.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblPhoneNo);
		
		tfPhoneNo = new JTextField();
		pCenter.add(tfPhoneNo);
		tfPhoneNo.setColumns(10);
		
		JLabel lblSex = new JLabel("성별");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblSex);
		
		JPanel panel = new JPanel();
		pCenter.add(panel);
		
		JRadioButton rdbtnFemale = new JRadioButton("여자");
		buttonGroup.add(rdbtnFemale);
		panel.add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("남자");
		buttonGroup.add(rdbtnMale);
		panel.add(rdbtnMale);
		
		JPanel pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("추가");
		pSouth.add(btnAdd);
		
		JButton btnClear = new JButton("취소");
		pSouth.add(btnClear);
	}

}
