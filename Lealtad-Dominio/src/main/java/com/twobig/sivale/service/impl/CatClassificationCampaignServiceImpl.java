package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.bd.to.RealUsersCampaigns;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;
import com.twobig.sivale.dao.RealCampaignsClassificationDAO;
import com.twobig.sivale.dao.RealUsersCampaignsDAO;
import com.twobig.sivale.service.CatClassificationCampaignService;

@Service
public class CatClassificationCampaignServiceImpl implements CatClassificationCampaignService{
	
	@Autowired
	public RealUsersCampaignsDAO realUsersCampaignsDAO;
	
	@Autowired
	public RealCampaignsClassificationDAO realCampaignsClassificationDAO;
	
	@Autowired
	public CatClassificationCampaignDAO catClassificationCampaignDAO;
	
	/**
	 * Variable to register the logs.
	 */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(CatClassificationCampaignServiceImpl.class);

	
	@Override
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(int userId) {
		
		List<RealUsersCampaigns> listA = realUsersCampaignsDAO.getRealUsersCampaignsByUserId(userId);
		
		List<Integer> campaignsByUser = new ArrayList<Integer>();
		
		for(RealUsersCampaigns listA2: listA){
			campaignsByUser.add(listA2.getCampaignId());
		}
		
		List<RealCampaignsClassification> classificationByUser = realCampaignsClassificationDAO.getRealCampaignsClassificationByCampaignId((ArrayList<Integer>) campaignsByUser);
		
		List<Integer> classificationByUserInt = new ArrayList<Integer>();
	
		for(int i = 0; i < classificationByUser.size(); i++){
			classificationByUserInt.add(classificationByUser.get(i).getClassificationId());
		}
		
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		linkedHashSet.addAll(classificationByUserInt);
		classificationByUserInt.clear();
		classificationByUserInt.addAll(linkedHashSet);
		
		return catClassificationCampaignDAO.getCatClassificationCampaignByClassificationId(classificationByUserInt);
	}
	
	@Override
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(int userId, int level) {
	
		List<RealUsersCampaigns> listA = realUsersCampaignsDAO.getRealUsersCampaignsByUserId(userId);
		
		List<Integer> campaignsByUser = new ArrayList<Integer>();
		
		for(RealUsersCampaigns listA2: listA){
			campaignsByUser.add(listA2.getCampaignId());
		}
		
		
		List<RealCampaignsClassification> classificationByUser = realCampaignsClassificationDAO.getRealCampaignsClassificationByCampaignId((ArrayList<Integer>)campaignsByUser);
		
		
		List<Integer> classificationByUserInt = new ArrayList<Integer>();
	
		for(int i = 0; i < classificationByUser.size(); i++){
			classificationByUserInt.add(classificationByUser.get(i).getClassificationId());
		}
		
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		linkedHashSet.addAll(classificationByUserInt);
		classificationByUserInt.clear();
		classificationByUserInt.addAll(linkedHashSet);
		
		return catClassificationCampaignDAO.getCatClassificationCampaignByClassificationId(classificationByUserInt, level);
	}
}
