package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.CatProfile;
import com.twobig.sivale.dao.CatProfileDAO;
import com.twobig.sivale.dao.impl.GenericDAOImpl;

/**
 * This class implements the interface CatProfileDAO.
 * 
 * @author 2Big
 *
 */
@Repository
public class CatProfileDAOImpl extends GenericDAOImpl<CatProfile, Long>
		implements CatProfileDAO {

	public CatProfileDAOImpl() {
		super(CatProfile.class);
	}

	@Override
	public void insert(CatProfile catProfile) {
		this.guardar(catProfile);
	}

	@Override
	public void update(CatProfile catProfile) {
		this.actualizar(catProfile);
	}

	@Override
	public void delete(CatProfile catProfile) {
		this.borrar(catProfile);
	}

	@Override
	public List<CatProfile> getAll() {
		return this.buscar();
	}


	@Override
	public CatProfile getCatProfileByProfileId(Integer profileId) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatProfile.class);

		criteria.add(Restrictions.eq(CatProfile.PROFILE_FIELD_CAT_PROFILE_ID,
				profileId));

		return getTByCriteria(criteria);

	}

	/**
	 * The explanation of this method is in the CatProfileDao interface.
	 */
	@Override
	public CatProfile getCatProfilesById(int catProfileId) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatProfile.class);

		criteria.add(Restrictions.eq(CatProfile.PROFILE_FIELD_CAT_PROFILE_ID,
				catProfileId));

		return getTByCriteria(criteria);
	}

}