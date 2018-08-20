package gui;

import javax.swing.JFrame;

public class Window extends JFrame{

	public Window() {
		
		
		
		pack();
		setLocationRelativeTo(null);
	}
	
	
	
	public static void main(String[] args) {
		Window w = new Window();
		w.setVisible(true);
		
	}
	
}
