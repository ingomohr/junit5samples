package org.junit5samples.moretags;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit5samples.reg.TagConstants;

class MoreTags {

	@Test
	@Tag(TagConstants.SLOW)
	void slowM1() throws Exception {
		Thread.sleep(5_000);
	}

	@Test
	@Tag(TagConstants.SLOW)
	void fastM1() throws Exception {
		Thread.sleep(20);
	}
	
	@Test
	@Tag(TagConstants.BAD_BANK)
	void notMyBug() {
		assertTrue(false);
	}

}
