package com.infosys.code.exercise;

import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikhila Reddy
 *
 */
public class NumberUtilTest {

	private SoftAssertions softAssertions;
	private NumberUtil numberUtil;
	long startTime;
	long endTime;

	@Before
	public void setUp() {
		startTime = System.currentTimeMillis();
		numberUtil = new NumberUtil();
		softAssertions = new SoftAssertions();
	}

	// Since it is only two numbers, we no need to tests for below scenarios:
	// NUll Checks
	// wrong or invalid data types
	// two characters
	// Extreme number ---

	@Test
	public void compareTwoEqualIntegerValues() {
		softAssertions.assertThat(numberUtil.compareTwoNumbers(10, 10)).as("Comparing two integer values")
				.isEqualTo(true);
		softAssertions.assertThat(numberUtil.compareTwoNumbers(0, 0)).as("Comparing two integer values")
				.isEqualTo(true);
		softAssertions.assertThat(numberUtil.compareTwoNumbers(1, 1)).as("Comparing two integer values")
				.isEqualTo(true);
		softAssertions.assertThat(numberUtil.compareTwoNumbers(-10, -10)).as("Comparing two integer values")
				.isEqualTo(true);
		softAssertions.assertThat(numberUtil.compareTwoNumbers(-100, -100)).as("Comparing two integer values")
				.isEqualTo(true);
	}

	@Test
	public void compareTwoNonEqualIntegerValues() {
		softAssertions.assertThat(numberUtil.compareTwoNumbers(10, 100)).as("Comparing two integer values")
				.isEqualTo(false);
	}

	@Test(expected = RuntimeException.class)
	public void compareTwoCharacters() {
		numberUtil.compareTwoNumbers(new Integer("a"), new Integer("a"));
	}

	@Test(expected = RuntimeException.class)
	public void compareSpecialCharacters() {
		numberUtil.compareTwoNumbers(new Integer("%"), new Integer("&"));
	}

	@Test(expected = RuntimeException.class)
	public void compareTwoNumberswithFloatInput() {
		numberUtil.compareTwoNumbers(new Integer("10.0"), new Integer("99.9"));
	}

	@Test(expected = RuntimeException.class)
	public void compareTwoNumberWithIntgerExceedLimit() {
		numberUtil.compareTwoNumbers(new Integer("1000000000000000000000000"),
				new Integer("99999999999999999999999999999999999999999"));
	}

	@After
	public void tearDown() {
		softAssertions.assertAll();
		endTime = System.currentTimeMillis();
		long totalTimeTaken = endTime - startTime;
		System.out.println("Elapsed time in milliseconds: " + totalTimeTaken);
	}

}
