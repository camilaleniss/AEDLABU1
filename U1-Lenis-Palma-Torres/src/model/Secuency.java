package model;

public class Secuency {

	private int [] intlist;
	private double [] doublelist;
	
	public Secuency() {
		
	}
	
	public boolean invariantAscendant(double [] list) {
		boolean isOrdered = false;
		int index = 0;
		while (!isOrdered && index<list.length-1) {
			isOrdered = list[index]<list[index+1] ? true : false;
		}
		return isOrdered;
	}
}
