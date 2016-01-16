package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TUserData;
import com.twobig.sivale.dao.TUserDataDAO;

@Repository
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

}
