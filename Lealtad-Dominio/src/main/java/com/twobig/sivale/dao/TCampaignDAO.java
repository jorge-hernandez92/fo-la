package com.twobig.sivale.dao;

import java.util.Date;
import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;


public interface TCampaignDAO {
	
	public List<TCampaign> getTCampaignByCampaignId(List<Integer> campaignId);
	
	public List<TCampaign> getTCampaignByCampaignIdCampaignNameAndDate(
			List<Integer> campaignId, String campaignName, Date startDate, Date endDate);
	
}
