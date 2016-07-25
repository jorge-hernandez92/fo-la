package com.twobig.sivale.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


/**
 *
 *
 */
public final class DateUtil {

	/**
	 * logger instance.
	 */
	
	//private static final Logger logger = LogManager.getLogger(DateUtil.class);
	/**
	 * DateUtil instance.
	 */
	private static DateUtil instance = null;
	/**
	 * List of date formats.
	 */
	private String[] dates = new String[]{
					"MM/dd/yyyy",
					"yyyy-MM-dd'T'HH:mm:ss",
					"yyyy-MM-dd'T'HH:mm:ss.SSSZ", 
					"yyyy-MM-dd'T'HH:mm:ssZ", 
					"yyyyMMdd:HHmmss", 
					"yyyy-MM-dd HH:mm:ss.SSSZ", 
					"yyyy-MM-dd HH:mm:ss.SSS", 
					"yyyy/MM/dd HH:mm:ss", 
					"MM/dd/yyyy HH:mm:ss a", 
					"yyyyMMdd"
				};
	
	/**
	 * Default constructor.
	 */
	private DateUtil() {
	}
	
	/**
	 * Method that gets the DateUtil instance.
	 * @return DateUtil instance
	 */
	public static DateUtil instance() {
		if (null == instance) {
			instance = new DateUtil();
		}
		return instance;
	}
	
	/**
	 * Method that generates date object from string.
	 * @param dateArg Date in string format
	 * @return Date object
	 */
	public Date getDateFromString(final String dateArg) {
		
		//BasicConfigurator.configure();
		
		Date returnDate = null;
		SimpleDateFormat formatter = null;
		String dateVerified = null;
		for (int i = 0; i < dates.length; i++) {
			formatter = new SimpleDateFormat(dates[i]);
			try {
				dateVerified = verifyTimezone(dateArg);
				if ((dateVerified.indexOf("/") == 1 || dateVerified.indexOf("/") == 2) && dates[i].indexOf("/") > 2) {
					continue;
				}
				returnDate =  formatter.parse(dateVerified);
				//if (logger.isInfoEnabled()) //logger.info("Date OK with format " + formatter.toPattern());
				break;
			} catch (Throwable th) {
				//if (logger.isDebugEnabled()) logger.debug("Date could not be formatted with format " + dates[i]);
			}
		}
		if (null == returnDate) {
			throw new RuntimeException("Invalid Date format for:" + dateArg);
		}
		//if (logger.isDebugEnabled()) logger.debug("Date: " + returnDate);
		return returnDate;
	}
	
	private static String verifyTimezone(String dateString) {
		
		boolean hasTimezone = dateString.matches(".+\\.*\\d*[-+]\\d{2}:\\d{2}");
		//if (logger.isDebugEnabled()) logger.debug("Has timezone: " + hasTimezone);
		if (hasTimezone) {
			int timezoneIndex = dateString.lastIndexOf("-");
			String dateWithoutTimezone = dateString.substring(0, dateString.lastIndexOf("-"));
			String timezone = dateString.substring(timezoneIndex).replace(":", "");
			//if (logger.isDebugEnabled()) logger.debug("Date with new timezone: " + dateWithoutTimezone + timezone);
			return dateWithoutTimezone + timezone;
		}
		
		return dateString;
	}
	
//	/**
//	 * Method that gets a string formatted from date object.
//	 * @param date Date object
//	 * @param format Format expected
//	 * @return String formatted from date
//	 */
//	public String getStringFromDateWithFormat(final Date date, final String format) {
//		SimpleDateFormat formatter = SimpleDateFormatFactory.get(format).get();
//		return formatter.format(date);
//	}
}
