package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TUserData;
import com.twobig.sivale.bd.to.TUserDataC;
import com.twobig.sivale.dao.TUserDataCDAO;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TUserDataCDAOImpl extends GenericDAOImpl<TUserDataC, Long> implements TUserDataCDAO {
	
	public TUserDataCDAOImpl(){
		super(TUserDataC.class);
	}

	@Override
	public List<TUserDataC> getTUserDataByCampaignIdAndUserId(int userId, int campaignId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TUserData.class);

		criteria.add(Restrictions.eq(TUserDataC.FIELD_CAMPAIGN_ID, campaignId));
		criteria.add(Restrictions.eq(TUserDataC.FIELD_USER_ID, userId));

		return getListByCriteria(criteria);
	}

	@Override
	public void insertTUserData(TUserDataC tUserDataC) {
		this.saveWithConstraints(tUserDataC);
	}

	@Override
	public void deleteTUserData(TUserDataC tUserDataC) {
		
		Session session =  this.getSessionFactory().openSession();
				
		Query query = session.createQuery("delete TUserData  where publicationId = :publicationId");
		query.setParameter("publicationId", tUserDataC.getCampaignId());
		 
		int result = query.executeUpdate();
		
	}

}
