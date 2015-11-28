package com.xm.sivale.services.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;

public class ServicesUser {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicesUser.class);
	
	public List<Map> getMyClassifications(Integer userId){
		
		LOGGER.info("UserId Value = " + userId);
		
		List<Map> classifications = new ArrayList<Map>();
		
		for (int i = 0; i < 5; i++){
			Map<String,String> classification = new HashMap<String,String>();
			classification.put("className", "Classification " + i);
			classification.put("companyName", "company " + i);
			classification.put("description", "Description ...");
			
			classifications.add(classification);
		}
		return classifications;
		
	}

	
	public List<Map> getCampaigns(Integer userId , Integer classification){
		
		LOGGER.info("UserId = " + userId + "     "+ "classificationId = " + classification);
		
		List<Map> campaigns= new ArrayList<Map>();
		Date date = new Date(115,11,1,0,0,0);
		
		for (int i = 0; i < 100; i++) {
			Map campaign = new HashMap();
			
			campaign.put("campaignId", "" + i);
			campaign.put("campaignName", "campaign Name "+i);
			campaign.put("classification", "classification "+i);
			campaign.put("startDate", date);
			campaign.put("endDate", date);
			
			
			campaigns.add(campaign);
		}
		
		return campaigns;
		
	}
		
	public List<TPublication> getPubliations(Integer UserId, Integer CampaignId){
		
		LOGGER.info("UserId = " + UserId + "     "+ "CampaignId = " + CampaignId);
		
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
		
		LOGGER.info("UserId = " + UserId + "     "+ "PublicationId = " + PublicationId);
		
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
