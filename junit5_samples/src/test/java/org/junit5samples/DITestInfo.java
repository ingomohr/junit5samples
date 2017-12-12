package org.junit5samples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("My DITestInfo Demo")
public class DITestInfo {

	public DITestInfo(TestInfo info) {
		assertEquals("My DITestInfo Demo", info.getDisplayName());
	}

	@BeforeEach
	@Tag("my tag")
	void init(TestInfo info) {
		final String name = info.getDisplayName();
		assertTrue("foo1()".equals(name) || "foo2()".equals(name));
	}

	@Test
	void foo1() {
	}

	@Test
	void foo2() {
	}
}
