package org.junit5samples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

class Repeat {

	@RepeatedTest(5)
	@Tag("whackle-candidates")
	void test() {
		assertTrue(Math.random() < 0.8D);
	}

	@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("Repeating")
	void test2() {

	}

}
