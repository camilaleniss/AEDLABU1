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

public class ValuesPanel extends JPanel implements ActionListener{
	
	public static final String ENTER_VALUES = "E";
	public static final String GENERATE_VALUES = "G";
	
	private Window main;
	private JButton btnEnter;
	private JButton btnGenerate;
	private JTextArea lblValues;

	public ValuesPanel(Window main) {
		this.main = main;
		setPreferredSize(new Dimension(500, 300));
		setLayout(new BorderLayout());
		
		String texto = "";
		for (int i = 1; i < 1001; i++) {
			texto+= i+" ";
		}
		lblValues = new JTextArea(texto);
		lblValues.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblValues.setEditable(false);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(lblValues);
		lblValues.setLineWrap(true);
		lblValues.setWrapStyleWord(true);
		
		btnEnter = new JButton("Enter Values");
		btnEnter.setActionCommand(ENTER_VALUES);
		btnEnter.addActionListener(this);
		
		btnGenerate = new JButton("Generate Values");
		btnGenerate.setActionCommand(GENERATE_VALUES);
		btnGenerate.addActionListener(this);
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1, 2, 10, 5));
		aux.setBorder(new EmptyBorder(5, 5, 5, 5));
		aux.add(btnEnter);
		aux.add(btnGenerate);
		
		add(scroll, BorderLayout.CENTER);
		add(aux, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(ENTER_VALUES)) {
			main.enterValues();
		} else if(e.getActionCommand().equals(GENERATE_VALUES)) {
			main.generateValues();
		} 
		
	}
	
	
}
