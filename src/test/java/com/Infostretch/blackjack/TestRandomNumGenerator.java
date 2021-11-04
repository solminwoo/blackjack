package com.Infostretch.blackjack;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestRandomNumGenerator {

	@Test
	void generateRandomNumBetween2and14() {
		IGenerator G = new Generator();
		int result = G.generateRandomNumBetween2and14();
		assertTrue(2 <= result && result <= 14);
	}

	// Question how can I actually know if result is not always 2;
	@Test
	void generateRandomNumIsNotAlwaysOneNumber() {
		IGenerator G = new Generator();
		int result1 = G.generateRandomNumBetween2and14();
		int result2 = G.generateRandomNumBetween2and14();
		try {
			while (result1 == result2) {
				result2 = G.generateRandomNumBetween2and14();
			}
		} catch (Error e) {
			System.out.println("Random Generator is generating only one number");
		}
		assertTrue(result1 != result2);
	}
}
