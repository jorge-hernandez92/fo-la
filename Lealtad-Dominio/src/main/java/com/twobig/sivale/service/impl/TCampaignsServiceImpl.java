package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.bd.to.RealUsersCampaigns;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.dao.RealCampaignsClassificationDAO;
import com.twobig.sivale.dao.RealUsersCampaignsDAO;
import com.twobig.sivale.service.TCampaignsService;

public class TCampaignsServiceImpl implements TCampaignsService {
	
	@Autowired
	public RealUsersCampaignsDAO realUsersCampaignsDAO;
	
	@Autowired
	public RealCampaignsClassificationDAO realCampaignsClassificationDAO;


	@Override
	public List<TCampaign> getCampaignByUserIdAndCampaignId(int userId, int campaignId) {
		
		List<RealUsersCampaigns> listA = realUsersCampaignsDAO.getRealUsersCampaignsByUserId(userId);  
		
		List<Integer> campaignsByUser = new ArrayList<Integer>();
		
		for(RealUsersCampaigns listA2: listA){
			campaignsByUser.add(listA2.getCampaignId());
		}
		
		//List<RealCampaignsClassification> classificationByUser = getRelCampaignsClassificationByCampaign( (ArrayList<Integer>) campaignsByUser);
		
		//List<RealCampaignsClassification> classificationByUser = realCampaignsClassificationDAO.getRealCampaignsClassificationByCampaignId((ArrayList<Integer>) campaignsByUser);
		
		List<RealCampaignsClassification> classificationByUser = realCampaignsClassificationDAO.getRealCampaignsClassificationByCampaignIdAndClassificationCampaignsId((ArrayList<Integer>) campaignsByUser, campaignId);
		
		
		for(int i = 0; i < classificationByUser.size(); i++){
			System.out.println(classificationByUser.get(i));
		}
		
//		List<Integer> classificationByUserInt = new ArrayList<Integer>();
//	
//		for(int i = 0; i < classificationByUser.size(); i++){
//			classificationByUserInt.add(classificationByUser.get(i).getClassificationId());
//			//System.out.println(classificationByUserInt.get(i));
//		}
//		
//		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
//		linkedHashSet.addAll(classificationByUserInt);
//		classificationByUserInt.clear();
//		classificationByUserInt.addAll(linkedHashSet);
		
		//return catClassificationCampaignDAO.getCatClassificationCampaignByClassificationId(classificationByUserInt);
		return null;
	}

}
