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

			int optRepeated = JOptionPane.showConfirmDialog(this,
					"Can there be repeated values? \n (Choose no only if the max value minus the min value is "
					+"greater than or equal to the number of elements)");
			if (optRepeated == JOptionPane.CANCEL_OPTION || optRepeated == -1) {
				throw new NullPointerException();
			} if(optRepeated == JOptionPane.NO_OPTION && end<number) {
				throw new NumberFormatException();
			}
			boolean repeated = optRepeated == JOptionPane.NO_OPTION;
			
			int optInt = JOptionPane.showConfirmDialog(this,
					"Can there be non-integer values?");
			if (optInt == JOptionPane.CANCEL_OPTION || optInt == -1) {
				throw new NullPointerException();
			} 
			boolean onlyInt = optInt == JOptionPane.NO_OPTION;

			String[] options = { "Sorted", "Sorted inversely", "Random order", "Disordered by a percentage" };

			int choice = JOptionPane.showOptionDialog(null, "Choose the configuration of the values.",
					"Choose an option", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
					options[0]);

			switch (choice) {
			case 0:
				clearValues();
				secuency.generateSorted(number, start, end, repeated, onlyInt);
				updateList();
				break;
			case 1:
				clearValues();
				secuency.generateSortedInversely(number, start, end, repeated, onlyInt);
				updateList();
				break;
			case 2:
				clearValues();
				secuency.generateRandomValues(number, start, end, repeated, onlyInt);
				updateList();
				break;
			case 3:
				String strDis = JOptionPane.showInputDialog(this, "What percentage of disorder?");
				if (strDis == null) {
					throw new NullPointerException();
				}
				double dis = Double.parseDouble(strDis);
				if (dis < 0 || dis > 100) {
					throw new NumberFormatException();
				}
				clearValues();
				secuency.generateDisorderedPercentage(number, start, end, repeated, dis, onlyInt);
				updateList();
				break;
			default:
				throw new NullPointerException();
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "You must enter valid values", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {

		}
	}

	public void clearValues() {
		secuency.clearList();
		updateList();
	}

	public void updateList() {
		vPanel.setText(secuency.getList());
		checkSorting();
	}

	public void checkSorting() {
		if (secuency.containsDecimals()) {
			oPanel.enableCounting(false);
			oPanel.enableRapid(false);
		} else {
			oPanel.enableCounting(true);
			oPanel.enableRapid(true);
		}
	}

	public void rapidSort() {
		long time = secuency.rapidSort();
		showTime(time);
		updateList();
	}

	public void showTime(long time) {
		JOptionPane.showMessageDialog(this, "The sorting took " + time + " milliseconds.");
	}

	public void countingSort() {
		long time = secuency.countingSort();
		showTime(time);
		updateList();
	}

	public void mergeSort() {
		long time = secuency.timeMergeSort();
		showTime(time);
		updateList();
	}

	public static void main(String[] args) {
		Window w = new Window();
		w.setVisible(true);
	}

}
