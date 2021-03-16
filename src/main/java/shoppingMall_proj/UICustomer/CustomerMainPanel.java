package shoppingMall_proj.UICustomer;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class CustomerMainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerMainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pTop = new JPanel();
		add(pTop);
		pTop.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pTopRight = new JPanel();
		pTop.add(pTopRight);
		
		JPanel pTopLeft = new JPanel();
		pTop.add(pTopLeft);
		
		JPanel pSouth = new JPanel();
		add(pSouth);
	}

}
