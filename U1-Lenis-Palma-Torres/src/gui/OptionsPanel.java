package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener{
	
	public static final String ENTER_VALUES = "ENTER";
	public static final String GENERATE_VALUES = "GENERATE";
	public static final String CLEAR_VALUES = "CLEAR";
	
	private Window main;
	private JButton btnEnter;
	private JButton btnGenerate;
	private JButton btnClear;

	public OptionsPanel(Window main) {
		this.main = main;

		btnEnter = new JButton("Enter Values");
		btnEnter.setActionCommand(ENTER_VALUES);
		btnEnter.addActionListener(this);
		
		btnGenerate = new JButton("Generate Values");
		btnGenerate.setActionCommand(GENERATE_VALUES);
		btnGenerate.addActionListener(this);
		
		btnClear = new JButton("Clear Values");
		btnClear.setActionCommand(CLEAR_VALUES);
		btnClear.addActionListener(this);

		setLayout(new GridLayout(1, 3, 10, 5));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		add(btnEnter);
		add(btnGenerate);
		add(btnClear);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(ENTER_VALUES)) {
			main.enterValues();
		} else if(e.getActionCommand().equals(GENERATE_VALUES)) {
			main.generateValues();
		} else if(e.getActionCommand().equals(CLEAR_VALUES)) {
			main.clearValues();
		} 
		
	}

	
}
