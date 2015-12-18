package com.twobig.sivale.dao;

import java.util.ArrayList;
import java.util.List;

import com.twobig.sivale.bd.to.RealCampaignsClassification;

public interface RealCampaignsClassificationDAO {
	
	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignId(ArrayList<Integer> campaignId); 

}
