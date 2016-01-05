package com.twobig.sivale.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.dao.TCampaignDAO;

@Repository
public class TCampaignDAOImpl extends GenericDAOImpl<TCampaign, Long> implements TCampaignDAO {

	public TCampaignDAOImpl() {
		super(TCampaign.class);
	}

	@Override
	public List<TCampaign> getTCampaignByCampaignId(List<Integer> campaignId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TCampaign.class);

		criteria.add(Restrictions.in(TCampaign.FIELD_COMPAIGN_ID, campaignId));

		return getListByCriteria(criteria);
	}

	@Override
	public List<TCampaign> getTCampaignByCampaignIdCampaignNameAndDate(List<Integer> campaignId, String campaignName,
			Date startDate, Date endDate) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TCampaign.class);

		criteria.add(Restrictions.in(TCampaign.FIELD_COMPAIGN_ID, campaignId));
		
		if(campaignName != null){
			
			criteria.add(Restrictions.like(TCampaign.FIELD_COMPAIGN_NAME, campaignName));
			
		}
		
		if(startDate != null || endDate != null){
			
			criteria.add(Restrictions.ge(TCampaign.FIELD_START_DATE, startDate));
			
			criteria.add(Restrictions.le(TCampaign.FIELD_END_DATE, endDate));
		}
		
		// TODO Auto-generated method stub
		return null;
	}
}
