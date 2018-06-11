package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class Table extends JFrame {
	public Table(String[] columns, String[][] data) {
		// create table with data
		JTable table = new JTable(data, columns);

		// add the table to the frame
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.WHITE);
		getContentPane().add(scrollPane);

		this.setTitle("Table Example");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

}