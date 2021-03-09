package shoppingMall_proj.panel.SBD;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchByDetail_TablePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SearchByDetail_TablePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
