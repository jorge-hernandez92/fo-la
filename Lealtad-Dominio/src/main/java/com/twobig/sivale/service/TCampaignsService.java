package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;

public interface TCampaignsService {
	
	public List<TCampaign> getCampaignByUserIdAndCampaignId(int userId,int campaignId);
}
