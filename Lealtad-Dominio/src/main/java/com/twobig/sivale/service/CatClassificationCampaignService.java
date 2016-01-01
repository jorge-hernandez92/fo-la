package com.twobig.sivale.service;


import java.util.List;

import com.twobig.sivale.bd.to.CatClassificationCampaign;

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
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByUserId(int userId);
	
}