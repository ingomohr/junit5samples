package org.junit5samples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Tags {

	@Test
	@Tag("slow")
	void slow1() throws Exception {
		Thread.sleep(5_000);
	}

	@Test
	@Tag("fast")
	void fast1() throws Exception {
		Thread.sleep(20);
	}

	@Test
	@Tag("fast")
	void fast2() throws Exception {
		Thread.sleep(20);
	}

}
