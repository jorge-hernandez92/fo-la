package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.SearchCampaignBean;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.service.FilterCampaignService;

@Service
public class FilterCampaignServiceImpl implements FilterCampaignService {
	
	@Autowired
	public RealUserCampaignDAO realUsersCampaignsDAO;
	
	@Autowired
	public TCampaignDAO tCampaignDAO;

	@Override
	public List<CampaignDetailBean> FilterCampaign(int userId, SearchCampaignBean searchCampaignBean) {
		
		List<RealUserCampaign> listA = realUsersCampaignsDAO.getRealUserCampaignByUserId(userId);

		List<Integer> listCampaigns = new ArrayList<Integer>();

		for (RealUserCampaign listA2 : listA) {
			
			listCampaigns.add(listA2.getCampaignId());
			
		}
		
		
		List<TCampaign> listTCampaigns = tCampaignDAO.getTCampaignByCampaignIdCampaignNameAndDate(
				listCampaigns, searchCampaignBean.getCampaignName(), searchCampaignBean.getStartDate(), 
				searchCampaignBean.getEndDate());
		
		for (TCampaign tCampaign : listTCampaigns) {
			System.out.println(tCampaign.toString());
		}
		
		return null;
	}

}
