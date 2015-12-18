package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.RealUsersCampaigns;

public interface RealUsersCampaignsDAO {
	
	public List<RealUsersCampaigns> getRealUsersCampaignsByUserId(int userId);
}
