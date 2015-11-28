package com.xm.sivale.services.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;

public class Test {

	public static void main(String args []){
		
		
		Map <String, Object> map = new HashMap<String, Object>();
		
		map.put("saludo", "hello world");
		map.put("saludo", "hola mundo");
		
		System.out.println((String)map.get("saludo"));
		
		String json = "{\"endDate\":\"2015-12-01T00:00:00\",\"campaignId\":\"0\",\"classification\":\"classification 0\",\"campaignName\":\"campaign Name 0\",\"startDate\":\"2015-12-01T00:00:00\"}";
		
		System.out.println(json);
		
		StringTokenizer st = new StringTokenizer(json, ",");
		
		String jsonCampaign ="";
		
		while (st.hasMoreTokens()) {
	         String aux =  st.nextToken();
	         if(!aux.startsWith("\"classification\""))
	        	 jsonCampaign += aux + ",";
	     }
		
		jsonCampaign = jsonCampaign.substring(0, jsonCampaign.length()-1);
		System.out.println(jsonCampaign);
		
//		ServicesUser services = new ServicesUser();
//		
//		List<Map> classifications = services.getMyClassifications((Integer)1);
//		List<Map> campains = services.getCampaigns((Integer)1, (Integer)1);
//		List<TPublication> publications = services.getPubliations((Integer)1, (Integer)1);
//		Map publicationDetail = services.showPublication((Integer)1, (Integer)1);
//		
//		System.out.println("******************************************************");
//		System.out.println(classifications.toString());
//		System.out.println("******************************************************");
//		System.out.println(campains.toString());
//		System.out.println("******************************************************");
//		System.out.println(publications.toString());
//		System.out.println("******************************************************");
//		System.out.println(publicationDetail.toString());
	}
}
