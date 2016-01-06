package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TUserDate;
import com.twobig.sivale.dao.TUserDateDAO;

@Repository
public class TUserDateDAOImpl extends GenericDAOImpl<TUserDate, Long> 
implements TUserDateDAO {
	
	public TUserDateDAOImpl(){
		super(TUserDate.class);
	}

	@Override
	public List<TUserDate> getTUserDateByPublicationIdAndUserId(int userId, int publicationId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TUserDate.class);

		criteria.add(Restrictions.eq(TUserDate.FIELD_PUBLICATION_ID, publicationId));
		criteria.add(Restrictions.eq(TUserDate.FIELD_USER_ID, userId));

		return getListByCriteria(criteria);
	}

}
