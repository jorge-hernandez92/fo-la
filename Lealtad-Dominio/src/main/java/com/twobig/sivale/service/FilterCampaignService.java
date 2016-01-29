package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.SearchCampaignBean;

public interface FilterCampaignService {
	
	public List<CampaignDetailBean> FilterCampaign(int userId, SearchCampaignBean searchCampaignBean);
	
	public List<CampaignDetailAdminBean> FilterCampaignAdmin(int companyId, SearchCampaignBean searchCampaignBean);
}
