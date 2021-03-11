package shoppingMall_proj.Salepanel.SBP;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchByProduct_TablePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SearchByProduct_TablePanel() {

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
