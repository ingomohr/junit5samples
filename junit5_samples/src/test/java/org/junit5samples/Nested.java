package org.junit5samples;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("root")
public class Nested {

	@Test
	void foo() {
	}

	@org.junit.jupiter.api.Nested
	@DisplayName("child1")
	class Child1 {

		Calculator calc;

		@BeforeEach
		void prep() {
			calc = new Calculator();
		}

		@Test
		void notNull() {
			assertNotNull(calc);
		}

	}

}
