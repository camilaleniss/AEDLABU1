package model;

import java.util.ArrayList;
import java.util.Random;

public class Secuency {

	private ArrayList<Double> list;

	public Secuency() {
		list = new ArrayList<Double>();
	}

	public boolean invariantAscendant(double[] list) {
		boolean isOrdered = false;
		int index = 0;
		while (!isOrdered && index < list.length - 1) {
			isOrdered = list[index] < list[index + 1] ? true : false;
		}
		return isOrdered;
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
				txt += String.format("%.0f", list.get(i)) + " / ";
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
	 * range. These numbers are not sorted. There is a 50% chance that a number is
	 * whole<br>
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
	 */
	public void generateRandomValues(int number, double start, double end, boolean repeated) {
		for (int i = 0; i < number; i++) {
			double random = new Random().nextDouble();
			double result = start + (random * (end - start));
			if (repeated && list.contains(result)) {
				i--;
			} else {
				list.add(Math.random() > 0.5? result : Math.round(result));
			}
		}
	}

}
