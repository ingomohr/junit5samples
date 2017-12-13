package org.junit5samples;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class Parameterized {

	// String values
	@ParameterizedTest
	@ValueSource(strings = { "A", "Lannister", "always", "pays", "his", "debts" })
	void strings(String candidate) {

		String val = candidate.toLowerCase();
		assertTrue(val.contains("a") || val.contains("s"));
	}

	// Int values
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 5, 8 })
	void integers(int candidate) {
		assertTrue(candidate > 0);

	}

	// Enum values
	@ParameterizedTest
	@EnumSource(Type.class)
	void enums(Type candidate) {
		assertTrue(Type.C == candidate || Type.A == candidate || Type.B == candidate);
	}

	@ParameterizedTest
	@EnumSource(value = Type.class, mode = Mode.EXCLUDE, names = { "A", "B" })
	void enumsWithMode(Type candidate) {
		assertEquals(Type.C, candidate);
	}

	private static enum Type {
		A, B, C
	}

	// String values by provider
	@ParameterizedTest
	@MethodSource(value = "stringProvider")
	void stringProvider(String candidate) {
		assertTrue(candidate.length() > 0);
	}

	static Stream<String> stringProvider() {
		return Stream.of("A", "B", "c", "d");
	}

	// Int values by provider
	@ParameterizedTest
	@MethodSource(value = "intProvider")
	void intProvider(int candidate) {
		assertTrue(candidate >= 2);
	}

	static IntStream intProvider() {
		return IntStream.range(0, 10).skip(2);
	}

	// Arguments values (aka construct)
	@ParameterizedTest
	@MethodSource(value = "bookProvider")
	void compositeProvider(String title, int id, List<String> authors) {
		assertThat(authors, CoreMatchers.hasItem("Author1"));
	}

	static Stream<Arguments> bookProvider() {
		return Stream.of(
				// @formatter:off
				Arguments.of("Book1", 0, Arrays.asList("Author1", "Author2")),
				Arguments.of("Book2", 1, Arrays.asList("Author1"))
		// @formatter:on
		);

	}

	// CSV
	@ParameterizedTest
	@CsvSource(delimiter = '&', value = { "Hey&0", "You&1" })
	void csv(String valLeft, int valRight) {
		assertTrue(!valLeft.isEmpty());
	}

	@ParameterizedTest
	@CsvFileSource(delimiter = ',', resources = { "/my.csv" })
	void csvFileSource(String valLeft, int valRight) {
		assertTrue(!valLeft.isEmpty());
	}

	// Arguments
	@ParameterizedTest
	@ArgumentsSource(MyArgsProvider.class)
	void args(String argument) {
		assertTrue(!argument.isEmpty());
	}

	static class MyArgsProvider implements ArgumentsProvider {

		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
			return Stream.of("One", "Two").map(Arguments::of);
		}
	}

}
