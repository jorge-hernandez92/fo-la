package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.RealUserCampaign;

public interface RealUserCampaignDAO {
	
	public List<RealUserCampaign> getRealUserCampaignByUserId(int userId);
}
