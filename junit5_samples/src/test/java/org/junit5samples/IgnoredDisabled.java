package org.junit5samples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IgnoredDisabled {

	@Test
	@Disabled("bad method")
	void iDidntRun() {
		fail("I am disabled. Fetch me chair!");
	}

}
