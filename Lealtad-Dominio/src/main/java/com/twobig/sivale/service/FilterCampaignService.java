package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.SearchCampaignBean;

public interface FilterCampaignService {
	
	public List<CampaignDetailBean> FilterCampaign(int userId, SearchCampaignBean searchCampaignBean);
	
	public List<CampaignDetailBean> FilterCampaignAdmin(int companyId, SearchCampaignBean searchCampaignBean);
}
