package shoppingMall_proj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import shoppingMall_proj.dao.Impl.LoginDaoImpl;

@SuppressWarnings("serial")
public class Shpping_LogIn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfID;
	private JPasswordField pfPass;
	private JButton btnLogin;
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Shpping_LogIn() {
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
		
		JPanel panel = new JPanel();
		pCenter.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblID = new JLabel("ID");
		panel.add(lblID);
		
		tfID = new JTextField();
		panel.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblPass = new JLabel("Password");
		panel.add(lblPass);
		
		pfPass = new JPasswordField();
		panel.add(pfPass);
		pfPass.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		pCenter.add(panel_1);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		panel_1.add(btnLogin);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogin) {
			actionPerformedBtnLogin(arg0);
		}
	}
	protected void actionPerformedBtnLogin(ActionEvent arg0) {
		
		
		String ID = tfID.getText();
		
		String ps1 = new String(pfPass.getPassword());
				
		if(true) {
			Shopping_Main frame = new Shopping_Main();
			frame.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다.");
			tfID.setText("");
			pfPass.setText("");
			tfID.requestFocus();
		}
	}
}
