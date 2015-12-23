package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.RealUsersCampaigns;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.dao.RealUsersCampaignsDAO;
import com.twobig.sivale.dao.TPublicationDAO;
import com.twobig.sivale.service.TPublicationService;

@Service
public class TPublicationServiceImpl implements TPublicationService{
	
	@Autowired
	public RealUsersCampaignsDAO realUsersCampaignsDAO;
	
	@Autowired
	public TPublicationDAO tPublicationDAO;

	@Override
	public List<TPublication> getTPublicationByUserIdAndCampaignId(int userId, int campaignId) {
		
		List<RealUsersCampaigns> listA = realUsersCampaignsDAO.getRealUsersCampaignsByUserId(userId);  
		
		List<Integer> campaignsByUser = new ArrayList<Integer>();
		
		for(RealUsersCampaigns listA2: listA){
			campaignsByUser.add(listA2.getCampaignId());
		}
		
		List<TPublication> publicaciones = tPublicationDAO.getTCampaignByPublicationId(campaignsByUser);
		
		return publicaciones;
	}

}
