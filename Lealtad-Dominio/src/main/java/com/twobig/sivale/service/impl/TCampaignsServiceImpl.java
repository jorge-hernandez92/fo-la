package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.bd.to.RealUsersCampaigns;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.dao.RealCampaignsClassificationDAO;
import com.twobig.sivale.dao.RealUsersCampaignsDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.service.TCampaignsService;

@Service
public class TCampaignsServiceImpl implements TCampaignsService {
	
	@Autowired
	public RealUsersCampaignsDAO realUsersCampaignsDAO;
	
	@Autowired
	public RealCampaignsClassificationDAO realCampaignsClassificationDAO;
	
	@Autowired
	public TCampaignDAO tCampaignDAO;


	@Override
	public List<TCampaign> getCampaignByUserIdAndCampaignId(int userId, int campaignId) {
		
		List<RealUsersCampaigns> listA = realUsersCampaignsDAO.getRealUsersCampaignsByUserId(userId);  
		
		List<Integer> campaignsByUser = new ArrayList<Integer>();
		
		for(RealUsersCampaigns listA2: listA){
			campaignsByUser.add(listA2.getCampaignId());
		}
		
		List<RealCampaignsClassification> classificationByUser = 
				realCampaignsClassificationDAO.getRealCampaignsClassificationByCampaignIdAndClassificationCampaignsId(
						(ArrayList<Integer>) campaignsByUser, campaignId);		
		
		List<Integer> tCampaignByCampaignId = new ArrayList<Integer>();
	
		for(int i = 0; i < classificationByUser.size(); i++){
			tCampaignByCampaignId.add(classificationByUser.get(i).getCampaignId());
		}
		
		
		List<TCampaign> tCampaign = tCampaignDAO.getTCampaignByCampaignId(tCampaignByCampaignId);
		return tCampaign;
	}

}
