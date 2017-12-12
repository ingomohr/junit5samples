package org.junit5samples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertAllTest {
	
	@Test
	void assertAll() {
		final Calculator calculator = new Calculator();

		Assertions.assertAll(
				// @formatter:off
				() -> assertEquals(1, calculator.add(1, 0)),
				() -> assertEquals(1, calculator.add(1, 1)),
				() -> assertEquals(1, calculator.add(1, 2)),
				() -> assertEquals(4, calculator.add(1, 3))
				// @formatter:on
		);
	}

}
