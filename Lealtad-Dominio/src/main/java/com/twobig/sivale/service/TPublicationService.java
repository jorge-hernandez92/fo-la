package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TPublication;

public interface TPublicationService {
	
	//QUITAR ESTE METODO
	public List<TPublication> getTPublicationByUserIdAndCampaignId(int userId,int campaignId);
	
	public List<TPublication> getTPublicationCampaignId(int campaignId);

}
