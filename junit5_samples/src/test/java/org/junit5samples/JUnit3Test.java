package org.junit5samples;

import junit.framework.TestCase;

public class JUnit3Test extends TestCase {
	
	private Calculator objUT;
	
	@Override
	public void setUp() {
		objUT = new Calculator();
	}
	
	public void testAdd() {
		assertEquals(4, objUT.add(2, 2));
	}
	
	public void testAdd2() {
		assertEquals(5, objUT.add(2, 3));
	}


}
