package com.twobig.sivale.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.dao.RealCampaignsClassificationDAO;

public class RealCampaignsClassificationDAOImpl extends
GenericDAOImpl<RealCampaignsClassification, Long> implements RealCampaignsClassificationDAO {
	
	public RealCampaignsClassificationDAOImpl(){
		super(RealCampaignsClassification.class);
		
	}

	@Override
	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignId(ArrayList<Integer> campaignId) {
		// TODO Auto-generated method stub
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RealCampaignsClassification.class);
		
		for(int i = 0; i < campaignId.size(); i++){
			criteria.add(Restrictions.eq(
					RealCampaignsClassification.FIELD_REL_CAMPAIGN_ID, campaignId.get(i)));
		}
		

		return getListByCriteria(criteria);
	}

}
