package com.twobig.sivale.service;

import java.io.File;
import java.util.List;

import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.beans.ExcelDataUserBean;

public interface ExcelService {

	public ExcelBean getExcelData(String path, String sheet);

	public ExcelBean getExcelData(String path);

	public ExcelBean getExcelData(File file);

	public List<ExcelDataUserBean> getFormatList(ExcelBean excelBean, String colum);

}
