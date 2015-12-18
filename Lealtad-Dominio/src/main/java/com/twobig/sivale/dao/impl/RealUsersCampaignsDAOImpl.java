package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.RealUsersCampaigns;
import com.twobig.sivale.bd.to.RelProfileFunctionality;
import com.twobig.sivale.dao.RealUsersCampaignsDAO;

@Repository
public class RealUsersCampaignsDAOImpl extends
GenericDAOImpl<RealUsersCampaigns, Long> implements RealUsersCampaignsDAO{

	public RealUsersCampaignsDAOImpl() {
		super(RealUsersCampaigns.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RealUsersCampaigns> getRealUsersCampaignsByUserId(int userId) {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RealUsersCampaigns.class);

		criteria.add(Restrictions.eq(
				RealUsersCampaigns.FIELD_REL_USER_ID, userId));

		return getListByCriteria(criteria);
	}

}
