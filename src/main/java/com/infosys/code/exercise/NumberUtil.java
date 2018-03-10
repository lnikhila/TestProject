package com.infosys.code.exercise;

import java.util.Scanner;
/**
 * This class contains common method related to Numbers
 * @author Nikhila Reddy
 *
 */
public class NumberUtil {
	
	/**
	 * This methods compares the number passed as parameters
	 * @param num1
	 * @param num2
	 * @return boolean - true or false based on the numbers, same or not
	 */
	public static boolean compareTwoNumbers(Integer num1, Integer num2) throws RuntimeException {
		try {
			num1.intValue();
			num2.intValue();
		} catch (NumberFormatException numberFormatException) {
			// TODO: We can use log4j for handling better way
			// For this exercise we choose to print the basic exception details
			throw new RuntimeException(numberFormatException.getMessage());
		}
		if (num1 == num2)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first integer");
		Integer firstInteger = scanner.nextInt();
		System.out.println("Enter the second integer");
		Integer secondInteger = scanner.nextInt();
		NumberUtil numberUtil = new NumberUtil();
		boolean result = numberUtil.compareTwoNumbers(firstInteger, secondInteger);
		System.out.println(result);
	}
}
