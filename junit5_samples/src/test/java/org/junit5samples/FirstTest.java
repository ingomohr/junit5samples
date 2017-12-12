package org.junit5samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstTest {

	private Calculator objUT;

	@BeforeEach
	void setupObjUT() {
		objUT = new Calculator();
	}

	@Test
	void equalsWithMessage() {
		assertEquals(4, objUT.add(2, 2), "Values equal?");
	}

	@Test
	void equalsWithMessagebySupplier() {
		assertEquals(4, objUT.add(2, 2), () -> "Values equal?");
	}

}
