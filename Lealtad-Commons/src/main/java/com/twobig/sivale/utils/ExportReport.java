package com.twobig.sivale.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.twobig.sivale.constants.PathConstants;

/**
 * 
 * This class is used to export the report Object to Excel file.
 * 
 * @author 2Big
 *
 */
public final class ExportReport {
	/**
	 * Variable to register the logs.
	 */
	private static final Logger logger = LogManager.getLogger(ExportReport.class);

	/**
	 * This method is used to build the report file from report object list.
	 * 
	 * @param reportObject
	 *            This indicates the report object list used to build the report
	 *            file.
	 * @param header
	 *            This indicates the header to write in the file.
	 * @param sheetName
	 *            This indicates the sheet name to write in the file.
	 * @return The byte[] that represent the report file.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static byte[] exportReportToFile(List<Object> reportObjects, String[] header, String[] attributeNames,
			String sheetName, String companyId, String fileName)
					throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, IOException {
		byte[] reportBytes = null;
		
		Properties commonsProps = PropUtils.getProperties();
		String outputPath = commonsProps.getProperty(PathConstants.ATTACHED_DIRECTORY) + fileName;
		FileInputStream inputStream = null;

		logger.info("exporting object List to Excel file...");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetName);
		HSSFCellStyle headCellStyle = workbook.createCellStyle();
		HSSFFont headFont = workbook.createFont();
		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headCellStyle.setFont(headFont);

		HSSFRow rowHead = sheet.createRow((short) 0);
		int columnIndexH = 0;
		for (String columnName : header) {
			HSSFCell cellHeader = rowHead.createCell(columnIndexH++);
			cellHeader.setCellValue(columnName);
			cellHeader.setCellStyle(headCellStyle);
		}

		int rowIndex = 1;
		for (Object reportObject : reportObjects) {
			PropertyUtilsBean propertyUtilBean = new PropertyUtilsBean();
			Map<?, ?> beanProperties = propertyUtilBean.describe(reportObject);
			HSSFRow rowValue = sheet.createRow((short) rowIndex++);
			int columnIndexV = 0;

			for (String attributeName : attributeNames) {
				logger.info(attributeName + " : " + beanProperties.get(attributeName));
				String valueToSet = " ";				
				Object attributeValue = beanProperties.get(attributeName);				
				if (attributeValue != null && attributeValue.getClass().equals(String.class)) {
					String value = attributeValue.toString();
					if(!value.isEmpty()){
						valueToSet = value;
					}
				}
				else if(attributeValue != null && attributeValue.getClass().equals(Integer.class)){
					String value = attributeValue.toString();
					if(!value.isEmpty()){
						valueToSet = value;
					}
				}
				else if(attributeValue != null && attributeValue.getClass().equals(Byte.class)){
					String value = attributeValue.toString();
					if(!value.isEmpty()){
						valueToSet = value;
					}
				}
				else if(attributeValue != null && attributeValue.getClass().equals(BigDecimal.class)){
					String value = attributeValue.toString();
					if(!value.isEmpty()){
						valueToSet = value;
					}
				}
				rowValue.createCell(columnIndexV++).setCellValue(valueToSet);
			}
		}

		FileOutputStream fileOut = new FileOutputStream(outputPath);
		workbook.write(fileOut);
		fileOut.close();

		inputStream = new FileInputStream(outputPath);
		reportBytes = IOUtils.toByteArray(inputStream);
		logger.info("The report '" + fileName + "' has been generated!");

		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

		return reportBytes;
	}
}
