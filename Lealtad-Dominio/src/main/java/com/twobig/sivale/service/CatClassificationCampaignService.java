package com.twobig.sivale.service;

import java.util.ArrayList;
import java.util.List;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.bd.to.RealUsersCampaigns;

/**
 * This interface contains the methods that are used to validate the users.
 * @author 2Big
 *
 */

public interface CatClassificationCampaignService {
	
	/**
	 * 
	 * @param userId
	 * @return list of RealUsersCampaigns
	 */
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(int userId);
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(int userId, int level);
	
}