package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;

public interface TCampaignsService {
	
	public List<TCampaign> getCampaignByUserIdAndClassificationCampaignsId(int userId,int classificationCampaignsId);
}
