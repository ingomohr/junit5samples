package org.junit5samples.moretags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MoreTags {

	@Test
	@Tag("slow")
	void slowM1() throws Exception {
		Thread.sleep(5_000);
	}

	@Test
	@Tag("fast")
	void fastM1() throws Exception {
		Thread.sleep(20);
	}

}
