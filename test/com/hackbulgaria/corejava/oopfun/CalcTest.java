package com.hackbulgaria.corejava.oopfun;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalcTest {

	private Calculator calculator;
	private double delta = 0.00001;

	@Before
	public void setUp() {
		this.calculator = new Calculator();
	}

	@Test
	public void testAddition() {
		double result = calculator.calculate("1+2");
		assertEquals(3, result, delta);
	}

	@Test
	public void testNegative() {
		double result = calculator.calculate(" 4*(-1)");
		assertEquals(-4, result, delta);
	}

	@Test
	public void testZeros() {
		double result = calculator.calculate("2-1 + 0");
		assertEquals(1, result, delta);
	}

	@Test
	public void testMultiplication() {
		double result = calculator.calculate("2*3*5 + 1");
		assertEquals(31, result, delta);
	}

	@Test
	public void testDivision() {
		double result = calculator.calculate("2*3*1/2     + 4/2");
		assertEquals(5, result, delta);

		result = calculator.calculate("1/2/2 + 5");
		assertEquals(6, result, delta);
	}

	@Test
	public void testBrackets() {
		double result = calculator.calculate("5*(21+ ((((1 +3)*5))) + (1/(2*5)))*2");
		assertEquals(411, result, delta);
	}
	
	@Test
	public void testPower(){
		double result = calculator.calculate("2^3 + 3^2");
		assertEquals(17, result,delta);
		
		result = calculator.calculate("2^3 + (5+3)^2");
		assertEquals(72, result,delta);
	}

}
