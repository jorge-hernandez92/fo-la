package com.twobig.sivale.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.beans.ExcelDataUserBean;
import com.twobig.sivale.service.ExcelService;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ExcelServiceImpl implements ExcelService {

	@Override
	public ExcelBean getExcelData(String path, String sheetName) {

		List<String> header = new ArrayList<String>();
		List<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

		try {
			FileInputStream file = new FileInputStream(new File(path));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet;

			if (sheetName != null && !sheetName.equals(""))
				sheet = workbook.getSheet(sheetName);
			else
				sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			int count = 0;

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				int colum = 0;
				HashMap<String, String> map = new HashMap<String, String>();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);

					if (count == 0) {

						header.add(cell.getStringCellValue());

					} else if(colum < header.size()){
						map.put(header.get(colum), cell.getStringCellValue());
					} else System.out.println("------------- fila : " + count + "-------------");
					colum++;
				}

				if (map.size() > 0)
					rows.add(map);

				count++;

			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return new ExcelBean(header, rows);
	}

	@Override
	public ExcelBean getExcelData(String path) {
		return getExcelData(path, null);
	}

	@Override
	public List<ExcelDataUserBean> getFormatList(ExcelBean excelBean, String Id) {

		List<ExcelDataUserBean> list = new ArrayList<ExcelDataUserBean>();

		if (excelBean != null) {
			if (excelBean.getHeader() != null && excelBean.getHeader().size() > 0 && excelBean.getRows() != null
					&& excelBean.getRows().size() > 0) {

				if (!this.existKey(excelBean, Id))
					return null;
				
				for (HashMap<String, String> row : excelBean.getRows()){
					
					ExcelDataUserBean userData = new ExcelDataUserBean(); 
					userData.setUserId(row.get(Id));
					
					JSONObject json= new JSONObject(row);
					userData.setData(json.toString());
					
					list.add(userData);
				}
				return list;
			}
			return null;
		} else {
			return null;
		}

	}

	private boolean existKey(ExcelBean excelBean, String headKey) {
		for (String key : excelBean.getHeader()) {
			if (headKey.equals(key))
				return true;
		}
		return false;
	}

}
