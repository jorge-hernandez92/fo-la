package com.xm.sivale.services.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;

public class ServicesUser {
	
	
	
	public List<Map> getMyClassifications(Integer userId){
		
		List<Map> classifications = new ArrayList<Map>();
		
		for (int i = 0; i < 5; i++) {
			Map<String,String> classification = new HashMap<String,String>();
			classification.put("className", "Classification " + i);
			classification.put("companyName", "company " + i);
			classification.put("description", "Description ...");
			
			classifications.add(classification);
		}
		
		return classifications;
		
	}

	
	public List<Map> getCampaings(Integer userId , Integer classification){
		
		List<Map> campaings= new ArrayList<Map>();
		
		for (int i = 0; i < 100; i++) {
			Map<String,String> campaing = new HashMap<String,String>();
			campaing.put("campaingName", "campaing Name " + i);
			campaing.put("classification", "classification " + i);
			campaing.put("startDate", "1/11/2015");
			campaing.put("endDate", "1/12/2015");
			
			
			campaings.add(campaing);
		}
		
		return campaings;
		
	}
		
	public List<TPublication> getPubliations(Integer UserId, Integer CampaingId){
		
		List<TPublication> publications= new ArrayList<TPublication>();
		
		for (int i = 0; i < 5; i++) {

			TPublication publication = new TPublication();
			
			Date date = new Date(115,11,1,0,0,0);
			
			publication.setPublicationId(i);
			publication.setName("Publication Name " + i);
			publication.setPublishedDate(date);
			publication.setDataFilePage("Description "+i);
			
			publications.add(publication);
		}
		
		return publications;
		
	}
	
	public Map showPublication(Integer UserId, Integer PublicationId){
		
		Map map = new HashMap<>();
		
		String html = 	"<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\">" +
						"<title>Insert title here</title></head><body><div> " +
						"Publication Test </div></body></html>";
		
		List<TAttachedFile> files = new ArrayList<TAttachedFile>();
		
		TAttachedFile file = new TAttachedFile();
		file.setFileName("attached1.pfd");
		file.setAttachedFileId(1);
		files.add(file);
		
		file = new TAttachedFile();
		file.setFileName("attached2.pfd");
		file.setAttachedFileId(2);
		files.add(file);
		
		map.put("html", html);
		map.put("listFiles", files);
		
		return map;
	}


}
