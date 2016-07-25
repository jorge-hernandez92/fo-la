package com.twobig.sivale.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * This class contains several methods that are useful in all the project.
 * 
 * @author 2Big
 *
 */
public class PropUtils {

	/**
	 * Variable to register the logs.
	 */
	//private static final Logger logger = LogManager.getLogger(PropUtils.class);

	/**
	 * Variable that indicate the name of the configuration properties.
	 */
	private static String PROPERTIES_NAME = "app.properties";

	/**
	 * This method get the configuration properties that are stored in the
	 * application.
	 * 
	 * @return the configuration properties.
	 */
	public static Properties getProperties() {

		Properties props = new Properties();
		InputStream input = PropUtils.class.getClassLoader()
				.getResourceAsStream(PROPERTIES_NAME);
		try {
			props.load(input);
		} catch (IOException e) {
			//logger.info(e.getMessage(), e);
		} finally {
			close(input);
		}

		return props;
	}

	/**
	 * It closes all the objects that can be closed.
	 * 
	 * @param closable
	 *            Object that can be close.
	 */
	private static void close(final Closeable closable) {

		if (closable == null) {
			return;
		}
		try {
			closable.close();
		} catch (IOException e) {
			//logger.info(e.getMessage(), e);
		}
	}

	/**
	 * This method gets the current date where the application is running.
	 * 
	 * @return A date in string with the format yyyyMMddHHmmss.
	 */
	public static String getCurrentDate() {

		Date date = Calendar.getInstance().getTime();
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(date);
		return dateString;
	}

	public static String parseDateString(String dateString) {

		DateFormat indate = new SimpleDateFormat("M/d/yy");
		SimpleDateFormat outdate = new SimpleDateFormat("yyyyMMdd");
		Date date;
		String outputDate = "";
		try {
			date = indate.parse(dateString);
			outputDate = outdate.format(date);
		} catch (ParseException e) {
			//logger.info("Error parsing the date: " + e.getMessage());
		}

		return outputDate;
	}
}
