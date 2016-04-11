package com.twobig.sivale.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.twobig.sivale.constants.HTMLParserConstants;
import com.twobig.sivale.service.HTMLParserService;

public class HTMLParserServiceImpl implements HTMLParserService {

	@Override
	public String getHTML(String htmlPath, String data) {

		if(data == null){
			String file = this.fileToString(htmlPath);
			return file;
		}
		
		HashMap<String, Object> map;
		try {
			map = (HashMap<String, Object>) toMap(new JSONObject(data));

			List<String> tokens = getKeys(map);

			String file = this.fileToString(htmlPath);

			for (int i = 0; i < tokens.size(); i++) {

				String value = (String) map.get(tokens.get(i));

				if (value != null)
					file = file.replace(HTMLParserConstants.TAG_PREFIX + tokens.get(i) + HTMLParserConstants.TAG_SUFFIX,
							value);
			}
			return file;

		} catch (JSONException e) {
			return null;
		}

	}

	private String fileToString(String path) {
		String file = "";
//		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//
//			String sCurrentLine;
//
//			while ((sCurrentLine = br.readLine()) != null) {
//				file += sCurrentLine;
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(path);
			BufferedReader br = new BufferedReader(fileReader);
			
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				file += sCurrentLine;
			}
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}

	private Map<String, Object> toMap(JSONObject object) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	private List<Object> toList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			list.add(value);
		}
		return list;
	}

	private List<String> getKeys(HashMap<String, Object> map) {
		List<String> list = new ArrayList<String>();

		for (String key : map.keySet()) {
			list.add(key);
		}

		return list;
	}
}
