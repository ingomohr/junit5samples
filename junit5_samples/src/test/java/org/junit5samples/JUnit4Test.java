package org.junit5samples;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JUnit4Test {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void prepClass() {
		System.out.println("prepClass");
	}

	private Calculator objUT;

	@Before
	public void prep() {
		objUT = new Calculator();
	}

	@Test
	public void add() {
		assertEquals("Values equal?", 2, objUT.add(1, 1));
	}
	
	@Test
	public void exceptionThrown() {
		
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("oo");
		
		throw new RuntimeException("woot");
	}

}
