package org.junit5samples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DisplayNames {

	@Test
	@DisplayName("This is a test :)")
	void test() {
	}

	@ParameterizedTest(name = " >>{0}<<")
	@ValueSource(strings = { "a", "b", "c" })
	@DisplayName(value = "Candidate is an")
	void foo(String candidate) {
	}

}
