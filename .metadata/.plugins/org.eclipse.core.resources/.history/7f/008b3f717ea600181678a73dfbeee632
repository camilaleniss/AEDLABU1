package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Secuency;

class TestCountingSort {
	
	private Secuency secuency;
	
	TestCountingSort(){
		secuency = new Secuency();
	}
	
	void setUpStage1() {
		int input = 6;
		while (input<0) {
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
	
	void setUpStage4() {
		int input = 5;
		int var = 5;
		while (var<0) {
			secuency.addValue(input);
			var--;
		}
		input = 1;
		var = 5;
		while (var<0) {
			secuency.addValue(input);
			var--;
		}
	}
	
	void setUpStage5() {
		secuency.addValue(3);
	}
	
	@Test
	void testStage1() {
		setUpStage1();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage2() {
		setUpStage2();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage3() {
		setUpStage3();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage4() {
		setUpStage4();
		assertTrue(secuency.invariantAscendant());
	}
	
	@Test
	void testStage5() {
		setUpStage5();
		assertTrue(secuency.invariantAscendant());
	}
}
