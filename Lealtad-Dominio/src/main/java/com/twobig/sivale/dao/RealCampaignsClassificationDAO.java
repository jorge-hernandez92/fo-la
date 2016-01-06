package com.twobig.sivale.dao;

import java.util.ArrayList;
import java.util.List;

import com.twobig.sivale.bd.to.RealCampaignsClassification;

public interface RealCampaignsClassificationDAO {

	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignId(ArrayList<Integer> campaignId);

	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignId(int campaignId);

	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignIdAndClassificationCampaignsId(
			ArrayList<Integer> campaignId, int classificationCampaignsId);

}
