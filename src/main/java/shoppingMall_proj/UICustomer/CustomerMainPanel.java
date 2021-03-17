package shoppingMall_proj.UICustomer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class CustomerMainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerMainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		CsContentPanel pTop = new CsContentPanel();
		add(pTop);
		pTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		CsSearchPanel pSouth = new CsSearchPanel();
		add(pSouth);
		
		JPanel panel = new JPanel();
		add(panel);
	}

}
