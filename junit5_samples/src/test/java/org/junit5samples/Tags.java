package org.junit5samples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit5samples.reg.TagConstants;

class Tags {

	@Test
	@Tag(TagConstants.SLOW)
	void slow1() throws Exception {
		Thread.sleep(5_000);
	}

	@Test
	@Tag(TagConstants.SLOW)
	void fast1() throws Exception {
		Thread.sleep(20);
	}

	@Test
	@Tag(TagConstants.SLOW)
	void fast2() throws Exception {
		Thread.sleep(20);
	}

}
