package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.CatPublicationUser;
import com.twobig.sivale.dao.CatPublicationUserDAO;

@Repository
public class CatPublicationUserDAOImlp extends GenericDAOImpl<CatPublicationUser, Long>
		implements CatPublicationUserDAO {

	public CatPublicationUserDAOImlp() {
		super(CatPublicationUser.class);
	}

	@Override
	public List<CatPublicationUser> getCatPublicationUserByPublicationIdAndUserId(int userId, int publicationId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CatPublicationUser.class);

		criteria.add(Restrictions.eq(CatPublicationUser.FIELD_PUBLICATION_ID, publicationId));
		criteria.add(Restrictions.eq(CatPublicationUser.FIELD_USER_ID, userId));

		return getListByCriteria(criteria);
	}

}
