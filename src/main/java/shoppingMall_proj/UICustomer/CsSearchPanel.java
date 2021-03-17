package shoppingMall_proj.UICustomer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class CsSearchPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CsSearchPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JLabel label_1 = new JLabel("회원 검색");
		add(label_1);
		
		JComboBox comboBox = new JComboBox();
		add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1);
		
		JButton button_1 = new JButton("검색");
		add(button_1);
		
		JLabel label_3 = new JLabel("전화번호로 검색");
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		add(textField_3);
		
		JButton button_3 = new JButton("검색");
		add(button_3);
	}

}
