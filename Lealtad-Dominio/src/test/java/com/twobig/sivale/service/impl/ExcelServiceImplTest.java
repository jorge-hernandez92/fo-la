package com.twobig.sivale.service.impl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.beans.ExcelDataUserBean;

public class ExcelServiceImplTest {

	final static Logger logger = Logger.getLogger(ExcelServiceImplTest.class);

	@Test
	public void getDatabySheet() {
		ExcelServiceImpl excelservice = new ExcelServiceImpl();
		ExcelBean excelBean = excelservice.getExcelData("src/test/resources/FORD.xlsx", "Hoja1");
		assertNotNull("ExcelBean Null", excelBean);

		for (String key : excelBean.getHeader()) {
			logger.info(key);
		}
		for (HashMap<String, String> row : excelBean.getRows()) {
			logger.info(row.toString());
		}
	}

	@Test
	public void getData() {
		ExcelServiceImpl excelservice = new ExcelServiceImpl();
		ExcelBean excelBean = excelservice.getExcelData("src/test/resources/FORD.xlsx");
		assertNotNull("ExcelBean Null", excelBean);

		for (String key : excelBean.getHeader()) {
			logger.info(key);
		}
		for (HashMap<String, String> row : excelBean.getRows()) {
			logger.info(row.toString());
		}
	}

	@Test
	public void getFormatList() {
		ExcelServiceImpl excelservice = new ExcelServiceImpl();
		ExcelBean excelBean = excelservice.getExcelData("src/test/resources/FORD.xlsx", "Hoja2");
		List<ExcelDataUserBean> dataList = excelservice.getFormatList(excelBean, "ID STARS GERENTE");

		assertNotNull("DataList Null", dataList);

		for (ExcelDataUserBean dataUser : dataList) {
			System.out.println("***" + dataUser.getUserId() + "***" + dataUser.getData());
		}
	}
	
	@Test
	public void maptest() throws JSONException {
		
		JSONObject jsonObj = new JSONObject("{\"BONO 1\":\"x\",\"ID STARS GERENTE\":\"SIN GERENTE EN STARS\",\"CONCATENADO\":\"M1234SLSMGR\"}");
		
		Map<String,Object> map = toMap(jsonObj);
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("Key1", "value");
//		map.put("Key2", "value");
//		map.put("Key3", "value");
//		map.put("Key4", "value");
		
		for (String key : map.keySet()) {
			System.out.println("***" + key + "***");
		}
	}

	public Map<String, Object> toMap(JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);

	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}
	
	public List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
}
