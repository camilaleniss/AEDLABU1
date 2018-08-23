package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Secuency;

class TestRapidSort {

	private Secuency secuency;
	
	TestRapidSort(){
		secuency = new Secuency();
	}
	
	void setUpStage1() {
		int input = 6;
		while (input>0) {
			secuency.addValue(input);
			input--;
		}
	}
	
	void setUpStage2() {
		for (int i=0; i<50; i++) {
			secuency.addValue(i+1);
		}
	}
	
	void setUpStage3() {
		for (int i=0; i<50; i++) {
			secuency.addValue(3);
		}
	}
	
	//List = {5.1, 5.35, 5.6, 5.2, 5.9, 1.1, 1.5, 1.6, 1.9}
	void setUpStage4(){
		secuency.addValue(5.1);
		secuency.addValue(5.35);
		secuency.addValue(5.6);
		secuency.addValue(5.2);
		secuency.addValue(5.9);
		secuency.addValue(1.1);
		secuency.addValue(1.5);
		secuency.addValue(1.6);
		secuency.addValue(1.9);
	}
	
	void setUpStage5() {
		secuency.addValue(3.6);
	}
	
	void setUpStage6() {
		secuency.generateRandomValues(20, -10, 10, false, false);
	}
	
	
	@Test
	void testStage1() {
		setUpStage1();
		secuency.rapidSort();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage2() {
		setUpStage2();
		secuency.rapidSort();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage3() {
		setUpStage3();
		secuency.rapidSort();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage4() {
		setUpStage4();
		secuency.rapidSort();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage5() {
		setUpStage5();
		secuency.rapidSort();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage6() {
		setUpStage6();
		secuency.rapidSort();
		assertTrue(secuency.invariantAscendant());
	}
	
}
