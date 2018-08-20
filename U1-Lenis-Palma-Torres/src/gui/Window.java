package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame{
	
	private ValuesPanel vPanel;
	private OptionsPanel oPanel;

	public Window() {
		
		setTitle("Sorting");
		setLayout(new BorderLayout());
		vPanel = new ValuesPanel();
		oPanel = new OptionsPanel(this);
		add(vPanel, BorderLayout.CENTER);
		add(oPanel, BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void enterValues() {
		JOptionPane.showMessageDialog(this, "Enter");
	}
	
	public void generateValues() {
		JOptionPane.showMessageDialog(this, "Generate");
	}
	
	public void emptyValues() {
		
	}
	
	public static void main(String[] args) {
		Window w = new Window();
		w.setVisible(true);
		
	}
	
}
