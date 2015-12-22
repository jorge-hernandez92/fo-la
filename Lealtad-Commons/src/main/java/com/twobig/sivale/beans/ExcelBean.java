package com.twobig.sivale.beans;

import java.util.HashMap;
import java.util.List;

public class ExcelBean {

	private List<String> header;

	private List<HashMap<String, String>> rows;

	public ExcelBean(List<String> header, List<HashMap<String, String>> rows) {
		this.header = header;
		this.rows = rows;
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<HashMap<String, String>> getRows() {
		return rows;
	}

	public void setRows(List<HashMap<String, String>> rows) {
		this.rows = rows;
	}

}
