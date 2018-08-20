package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ValuesPanel extends JPanel{
	
	public static final String ENTER_VALUES = "ENTER";
	public static final String GENERATE_VALUES = "GENERATE";
	public static final String EMPTY_VALUES = "EMPTY";
	
	private JTextArea lblValues;

	public ValuesPanel() {
		
		setPreferredSize(new Dimension(500, 300));
		setLayout(new BorderLayout());
		
		lblValues = new JTextArea("");
		lblValues.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblValues.setEditable(false);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(lblValues);
		lblValues.setLineWrap(true);
		lblValues.setWrapStyleWord(true);
		
		
		add(scroll, BorderLayout.CENTER);
	}
	
	public void setText(String t) {
		lblValues.setText(t);
	}
	
}
