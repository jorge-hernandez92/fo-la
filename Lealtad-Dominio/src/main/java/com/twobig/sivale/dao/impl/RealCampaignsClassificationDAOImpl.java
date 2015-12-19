package com.twobig.sivale.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.dao.RealCampaignsClassificationDAO;


@Repository
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
		
		criteria.add(Restrictions.in(RealCampaignsClassification.FIELD_REL_CAMPAIGN_ID, campaignId));
		
		
		//criteria.setProjection(Projections.distinct(Projections.property("campaignId")));
		
		
		return getListByCriteria(criteria);
	}

}
