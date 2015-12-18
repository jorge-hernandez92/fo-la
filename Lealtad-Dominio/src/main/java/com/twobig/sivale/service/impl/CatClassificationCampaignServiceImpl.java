package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.bd.to.RealUsersCampaigns;
import com.twobig.sivale.dao.RealCampaignsClassificationDAO;
import com.twobig.sivale.dao.RealUsersCampaignsDAO;
import com.twobig.sivale.service.CatClassificationCampaignService;

@Service
public class CatClassificationCampaignServiceImpl implements CatClassificationCampaignService{
	
	@Autowired
	public RealUsersCampaignsDAO realUsersCampaignsDAO;
	
	@Autowired
	public RealCampaignsClassificationDAO realCampaignsClassificationDAO;
	
	/**
	 * Variable to register the logs.
	 */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(CatClassificationCampaignServiceImpl.class);

	@Override
	public List<RealUsersCampaigns> getRealUsersCampaignsByUserId(int userId) {
		return realUsersCampaignsDAO.getRealUsersCampaignsByUserId(userId);
	}

	@Override
	public List<RealCampaignsClassification> getRelCampaignsClassificationByCampaign(ArrayList<Integer> campaignsByUser) {
		return realCampaignsClassificationDAO.getRealCampaignsClassificationByCampaignId(campaignsByUser);
	}
	
	
	
	

}
