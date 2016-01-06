package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TPublication;

public interface TPublicationService {
	
	public List<TPublication> getTPublicationByUserIdAndCampaignId(int userId,int campaignId);

}
