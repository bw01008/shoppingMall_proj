package shoppingMall_proj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import shoppingMall_proj.dto.Login;
import shoppingMall_proj.service.LoginService;

@SuppressWarnings("serial")
public class Shpping_LogIn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfID;
	private JPasswordField pfPass;
	private JButton btnLogin;
	private LoginService service;
	private JPanel pContent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shpping_LogIn frame = new Shpping_LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Shpping_LogIn() {
		service = new LoginService();
		initialize();
	}

	private void initialize() {
		setTitle("쇼핑몰관리 프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("쇼핑몰 관리프로그램");
		pNorth.add(lblTitle);

		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));

		pContent = new JPanel();
		pCenter.add(pContent);
		pContent.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblID = new JLabel("ID");
		pContent.add(lblID);

		tfID = new JTextField();
		pContent.add(tfID);
		tfID.setColumns(10);

		JLabel lblPass = new JLabel("Password");
		pContent.add(lblPass);

		pfPass = new JPasswordField();
		pContent.add(pfPass);
		pfPass.setColumns(10);

		JPanel pBtn = new JPanel();
		pCenter.add(pBtn);

		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		pBtn.add(btnLogin);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogin) {
			actionPerformedBtnLogin(arg0);
		}
	}

	private Login getLogin() {
		String ID = new String(tfID.getText().trim());
		String password = new String(pfPass.getPassword());
		return new Login(ID, password);
	}

	protected void actionPerformedBtnLogin(ActionEvent arg0) {
		Login logTry = getLogin();
		Login logInfo = service.LoginInfo(logTry);

		if (logTry.equals(logInfo)) {
			Shopping_Main frame = new Shopping_Main();
			frame.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
			tfID.setText("");
			pfPass.setText("");
			tfID.requestFocus();
		}

	}
}
