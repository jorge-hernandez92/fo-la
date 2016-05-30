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
import com.twobig.sivale.dao.TUserDataDAO;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TUserDataDAOImpl extends GenericDAOImpl<TUserData, Long> 
implements TUserDataDAO {
	
	public TUserDataDAOImpl(){
		super(TUserData.class);
	}

	@Override
	public List<TUserData> getTUserDataByPublicationIdAndUserId(int userId, int publicationId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TUserData.class);

		criteria.add(Restrictions.eq(TUserData.FIELD_PUBLICATION_ID, publicationId));
		criteria.add(Restrictions.eq(TUserData.FIELD_USER_ID, userId));

		return getListByCriteria(criteria);
	}

	@Override
	public void insertTUserData(TUserData tUserData) {
		this.saveWithConstraints(tUserData);
	}

	@Override
	public void deleteTUserData(TUserData tUserData) {
		
		Session session =  this.getSessionFactory().openSession();
				
		Query query = session.createQuery("delete TUserData  where publicationId = :publicationId");
		query.setParameter("publicationId", tUserData.getPublicationId());
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		    System.out.println("t_user_data was removed");
		}
	}
}
