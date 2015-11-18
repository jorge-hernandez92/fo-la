package com.twobig.sivale.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonsUtils {
	
	/**
	 * This constant is to sum one month when the calendar object returns the
	 * month from a date. This is done because the month returned by the
	 * calendar object start in 0.
	 */
	private static final int SUM_ONE_MONTH = 1;

	/**
	 * This constant is used when the length of month returned by the calendar
	 * object is 1, It's used to keep the format with two digits.
	 */
	private static final String ZERO_STRING = "0";

	/**
	 * This constant is to indicate the length of the month with one digit.
	 */
	private static final int MONTH_LENGTH_ONE_DIGIT = 1;
	
	/**
	 * This constant is to indicate the length of the day with one digit.
	 */
	private static final int DAY_LENGTH_ONE_DIGIT = 1;

	/**
	 * This constant is to indicate the separator to a directory.
	 */
	private static final String DIRECTORY_SEPARATOR = "/";

	/**
	 * This method get the year and month from the current date.
	 * 
	 * @return The year and month from the current date.
	 */
	public static String getYearMonthFromCurrentDate() {

		Calendar calendar = Calendar.getInstance();
		Date date = Calendar.getInstance().getTime();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		month = month + SUM_ONE_MONTH;

		String finalMonth = Integer.toString(month);

		if (finalMonth.length() == MONTH_LENGTH_ONE_DIGIT) {

			finalMonth = ZERO_STRING + finalMonth;
		}

		String finalValue = Integer.toString(year) + DIRECTORY_SEPARATOR
				+ finalMonth;

		return finalValue;
	}
	
	/**
	 * This method get the year, month and day from the current date.
	 * 
	 * @return The year, month and day from the current date.
	 */
	public static String getYearMonthDayFromCurrentDate() {

		Calendar calendar = Calendar.getInstance();
		Date date = Calendar.getInstance().getTime();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		month = month + SUM_ONE_MONTH;
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		String finalMonth = Integer.toString(month);
		String finalDay = Integer.toString(day);

		if (finalMonth.length() == MONTH_LENGTH_ONE_DIGIT) {

			finalMonth = ZERO_STRING + finalMonth;
		}
		
		if (finalDay.length() == DAY_LENGTH_ONE_DIGIT) {
			finalDay = ZERO_STRING + finalDay;
		}

		String finalValue = Integer.toString(year) + DIRECTORY_SEPARATOR
				+ finalMonth + DIRECTORY_SEPARATOR + finalDay;

		return finalValue;
	}
	
	/**
	 * This method gets the current date where the application is running.
	 * 
	 * @return A date in string with the format yyyyMMddHHmmss.
	 */
	public static String getCurrentDateNoSpaces() {

		Date date = Calendar.getInstance().getTime();
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(date);
		return dateString;
	}
}
