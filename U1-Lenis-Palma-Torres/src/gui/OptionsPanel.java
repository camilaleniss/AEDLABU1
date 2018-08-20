package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class OptionsPanel extends JPanel implements ActionListener{
	
	public static final String ENTER_VALUES = "ENTER";
	public static final String GENERATE_VALUES = "GENERATE";
	public static final String EMPTY_VALUES = "EMPTY";
	
	private Window main;
	private JButton btnEnter;
	private JButton btnGenerate;

	public OptionsPanel(Window main) {
		this.main = main;

		btnEnter = new JButton("Enter Values");
		btnEnter.setActionCommand(ENTER_VALUES);
		btnEnter.addActionListener(this);
		
		btnGenerate = new JButton("Generate Values");
		btnGenerate.setActionCommand(GENERATE_VALUES);
		btnGenerate.addActionListener(this);

		setLayout(new GridLayout(1, 2, 10, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		add(btnEnter);
		add(btnGenerate);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(ENTER_VALUES)) {
			main.enterValues();
		} else if(e.getActionCommand().equals(GENERATE_VALUES)) {
			main.generateValues();
		} else if(e.getActionCommand().equals(EMPTY_VALUES)) {
			main.emptyValues();
		} 
		
	}

	
}
