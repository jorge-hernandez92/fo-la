package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.dao.RealUserCampaignDAO;

@Repository
public class RealUserCampaignDAOImpl extends
GenericDAOImpl<RealUserCampaign, Long> implements RealUserCampaignDAO{

	public RealUserCampaignDAOImpl() {
		super(RealUserCampaign.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RealUserCampaign> getRealUserCampaignByUserId(int userId) {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RealUserCampaign.class);

		criteria.add(Restrictions.eq(
				RealUserCampaign.FIELD_REL_USER_ID, userId));

		return getListByCriteria(criteria);
	}
}