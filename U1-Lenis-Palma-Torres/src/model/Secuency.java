package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Secuency class is resposible for handing the sort and generate fuctions of
 * the program using a List
 * 
 * @author Maria Camila Lenis, Juan Sebastian Palma and Javier Andres Torres
 *
 */
public class Secuency {
	/**
	 * The list where all the values we have to sort will be stored
	 */
	private List<Double> list;

	/**
	 * The constructor of a Secuency object <b>post:</b>list have been initialized
	 * and is empty<br>
	 */
	public Secuency() {
		list = new ArrayList<Double>();

	}

	/**
	 * Removes all the elements from the list.<br>
	 * <b>Pre:</b> The list != null.<br>
	 * <b>Post:</b> The list is empty.
	 */
	public void clearList() {
		list.clear();
	}

	/**
	 * Creates a text string that contains each number in the list.<br>
	 * <b>Pre:</b> The list != null.<br>
	 * 
	 * @return A text string that contains each number in the list, separated by a
	 *         space and a slash.
	 */
	public String getList() {
		String txt = "";
		for (int i = 0; i < list.size(); i++) {
			double current = list.get(i);
			if (current % 1 == 0) {
				txt += String.format("%.0f", list.get(i)) + " / "; // If the numb is integer, the decimals are not
																	// printed
			} else {
				txt += list.get(i) + " / ";
			}
		}
		return txt;
	}

	/**
	 * Adds a value to the list.<br>
	 * <b>Pre:</b> The list != null.<br>
	 * <b>Post:</b> The value is added to the list.
	 * 
	 * @param value
	 *            The value to be added.
	 */
	public void addValue(double value) {
		list.add(value);
	}

	/**
	 * This method generates a given number of random decimal numbers in a given
	 * range. These numbers are not sorted. <br>
	 * <b>Pre:</b> The list != null.<br>
	 * <b>Post:</b> The values are added to the list.
	 * 
	 * @param number
	 *            The number of values to be generated
	 * @param start
	 *            The minimum value
	 * @param end
	 *            The maximum value
	 * @param repeated
	 *            true if there cannot be repeated values in the list
	 * @param onlyInt
	 *            true if there can only be integer values
	 */
	public void generateRandomValues(int number, double start, double end, boolean repeated, boolean onlyInt) {
		for (int i = 0; i < number; i++) {
			double random = new Random().nextDouble();
			double result = start + (random * (end - start));
			double cons = onlyInt ? 1 : 0.5;
			result = Math.random() > cons ? result : Math.round(result); //
			if (repeated && list.contains(result)) {
				i--;
			} else {
				list.add(result);
			}
		}
	}

	/**
	 * This method generates a given number of random decimal numbers in a given
	 * range. These numbers are sorted. <br>
	 * <b>Pre:</b> The list != null.<br>
	 * <b>Post:</b> The values are added to the list.
	 * 
	 * @param number
	 *            The number of values to be generated
	 * @param start
	 *            The minimum value
	 * @param end
	 *            The maximum value
	 * @param repeated
	 *            true if there cannot be repeated values in the list
	 * @param onlyInt
	 *            true if there can only be integer values
	 */
	public void generateSorted(int number, double start, double end, boolean repeated, boolean onlyInt) {
		generateRandomValues(number, start, end, repeated, onlyInt);
		Collections.sort(list);
	}

	/**
	 * This method generates a given number of random decimal numbers in a given
	 * range. These numbers are sorted inversely. <br>
	 * <b>Pre:</b> The list != null.<br>
	 * <b>Post:</b> The values are added to the list.
	 * 
	 * @param number
	 *            The number of values to be generated
	 * @param start
	 *            The minimum value
	 * @param end
	 *            The maximum value
	 * @param repeated
	 *            true if there cannot be repeated values in the list
	 * @param onlyInt
	 *            true if there can only be integer values
	 */
	public void generateSortedInversely(int number, double start, double end, boolean repeated, boolean onlyInt) {
		generateSorted(number, start, end, repeated, onlyInt);
		Collections.reverse(list);
	}

	/**
	 * This method generates a given number of random decimal numbers in a given
	 * range. These numbers are disordered according to a given percentage.<br>
	 * <b>Pre:</b> The list != null.<br>
	 * <b>Post:</b> The values are added to the list.
	 * 
	 * @param number
	 *            The number of values to be generated
	 * @param start
	 *            The minimum value
	 * @param end
	 *            The maximum value
	 * @param repeated
	 *            True if there cannot be repeated values in the list
	 * @param disorder
	 *            The percentage of disorder the numbers must have. The percentage
	 *            must be greater than 0 and less than 100
	 * @param onlyInt
	 *            true if there can only be integer values
	 */
	public void generateDisorderedPercentage(int number, double start, double end, boolean repeated, double disorder,
			boolean onlyInt) {
		generateSorted(number, start, end, repeated, onlyInt);
		int k = (int) (list.size() * disorder / 100); // The number of disordered values
		int pairs = 0;
		for (int i = 0; i < list.size() - 1 && pairs < k / 2; i += 2) {
			double temp = list.get(i);
			list.set(i, list.get(i + 1));
			list.set(i + 1, temp);
			pairs++;
		}
	}

	/**
	 * This method checks whether the list contains decimal numbers<br>
	 * <b>Pre:</b> The list != null.<br>
	 * 
	 * @return true if the list contains decimal numbers
	 */
	public boolean containsDecimals() {
		boolean contains = false;
		for (int i = 0; i < list.size() && !contains; i++) {
			if (list.get(i) % 1 != 0) {
				contains = true;
			}
		}
		return contains;
	}

	/**
	 * This method sorts the list using the rapid sort algorithm<br>
	 * <b>Pre:</b> The list != null and all its elements are integers.<br>
	 */
	public long rapidSort() {
		long time = System.currentTimeMillis();
		if (list.size() > 0) {
			int min = (int) Math.floor(list.get(0));
			int max = min;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) < min) {
					min = (int) Math.floor(list.get(i));
				}
				if (list.get(i) > max) {
					max = (int) Math.floor(list.get(i));
				}
			}
			int[] aux = new int[max - min + 1];

			for (int i = 0; i < list.size(); i++) {
				int value = (int) Math.floor(list.get(i)) - min;
				aux[value]++;
			}

			List<Double> output = new ArrayList<Double>();

			for (int i = 0; i < aux.length; i++) {
				if (aux[i] > 0) {
					for (int j = 0; j < aux[i]; j++) {
						output.add((double) (i + min));
					}
				}
			}
			list = output;
		}

		return System.currentTimeMillis() - time;
	}

	public long mergeSort() {
		long time = System.currentTimeMillis();
		return System.currentTimeMillis() - time;
	}

	/**
	 * This method sorts the list using the counting sort algorithm<br>
	 * <b>Pre:</b> The list != null and all its elements are integers.<br>
	 */
	public long countingSort() {
		long time = System.currentTimeMillis();
		if (list.size() > 0) {
			int min = (int) Math.floor(list.get(0));
			int max = min;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) < min) {
					min = (int) Math.floor(list.get(i));
				}
				if (list.get(i) > max) {
					max = (int) Math.floor(list.get(i));
				}
			}
			int[] aux = new int[max - min + 1];

			for (int i = 0; i < list.size(); i++) {
				int value = (int) Math.floor(list.get(i)) - min;
				aux[value]++;
			}

			int sum = 0;
			for (int i = 0; i < aux.length; i++) {
				sum += aux[i];
				aux[i] = sum;
			}

			double[] output = new double[list.size()];
			for (int i = list.size() - 1; i >= 0; i--) {
				int index = aux[(int) (list.get(i) - min)];
				output[index - 1] = list.get(i);
				aux[(int) (list.get(i) - min)]--;

			}
			
			list.clear();
			for (int i = 0; i < output.length; i++) {
				double d = output[i];
				list.add(d);
			}
		}

		return System.currentTimeMillis() - time;
	}

	/**
	 * This method checks is the order of the item in List are sorted in an
	 * ascendant order. <b>pre:</b>List have been initialized<br>
	 * <b>post:</b>List have been checked<br>
	 * 
	 * @return true: if the list is sorted, false: if the list is not sorted
	 */
	public boolean invariantAscendant() {
		boolean isOrdered = true;
		int index = 0;
		while (isOrdered && index < list.size() - 1) {
			isOrdered = list.get(index) <= list.get(index + 1) ? true : false;
			index++;
		}
		return isOrdered;
	}

}
