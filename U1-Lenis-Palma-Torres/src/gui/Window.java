package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Secuency;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private ValuesPanel vPanel;
	private OptionsPanel oPanel;
	private Secuency secuency;

	public Window() {

		secuency = new Secuency();

		setTitle("Sorting");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		vPanel = new ValuesPanel();
		oPanel = new OptionsPanel(this);
		add(vPanel, BorderLayout.CENTER);
		add(oPanel, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
	}

	public void enterValues() {
		try {
			String strNumber = JOptionPane.showInputDialog(this, "How many values will you enter?");
			if (strNumber != null) {
				int number = Integer.parseInt(strNumber);
				if (number < 1) {
					throw new NumberFormatException();
				}

				for (int i = 0; i < number; i++) {
					String input = JOptionPane.showInputDialog(this, "Enter a number");
					if (input != null) {
						try {
							double value = Double.parseDouble(input);
							secuency.addValue(value);
							updateList();
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(this, "You must enter a number", "Error",
									JOptionPane.ERROR_MESSAGE);
							i--; // The user can retry entering a number
						}
					} else { // If the user presses cancel, he cannot enter more numbers
						i = number;
					}
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "You must enter a positive number", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void generateValues() {
		
		try {
			String strNumber = JOptionPane.showInputDialog(this, "How many values will be generated?");
			if (strNumber == null) {
				throw new NullPointerException();
			}
			int number = Integer.parseInt(strNumber);
			if (number < 1) {
				throw new NumberFormatException();
			}
			
			String strMin = JOptionPane.showInputDialog(this, "What is the minimum value?");
			if (strMin == null) {
				throw new NullPointerException();
			}
			double start = Double.parseDouble(strMin);
			
			String strMax = JOptionPane.showInputDialog(this, "What is the maximum value?");
			if (strMax == null) {
				throw new NullPointerException();
			}
			double end = Double.parseDouble(strMax);

			int optRepeated = JOptionPane.showConfirmDialog(this, "Can there be repeated values?");
			if (optRepeated == JOptionPane.CANCEL_OPTION) {
				throw new NullPointerException();
			}
			boolean repeated = optRepeated == JOptionPane.NO_OPTION;
			
			clearValues();
			secuency.generateRandomValues(number, start, end, repeated);
			updateList();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "You must enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {

		}
	}

	public void clearValues() {
		secuency.clearList();
		updateList();
	}

	public void updateList() {
		vPanel.setText(secuency.getList());
	}

	public static void main(String[] args) {
		Window w = new Window();
		w.setVisible(true);

	}

}
