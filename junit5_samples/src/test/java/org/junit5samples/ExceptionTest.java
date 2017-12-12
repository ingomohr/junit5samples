package org.junit5samples;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	void exceptionHandling() {
		RuntimeException ex = assertThrows(RuntimeException.class, () -> {
			throw new RuntimeException("wrong!");
		});

		assertThat(ex.getMessage(), is("wrong!"));
	}

}
