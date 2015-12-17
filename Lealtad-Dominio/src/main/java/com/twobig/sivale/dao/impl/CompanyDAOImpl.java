package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TCompany;
import com.twobig.sivale.dao.CompanyDAO;

import com.twobig.sivale.dao.impl.GenericDAOImpl;

@Repository
public class CompanyDAOImpl extends GenericDAOImpl<TCompany, Long> implements
		CompanyDAO {

	public CompanyDAOImpl() {
		super(TCompany.class);
	}

	@Override
	public void insert(TCompany companies) {
		this.guardar(companies);
	}

	@Override
	public void update(TCompany companies) {
		this.actualizar(companies);
	}

	@Override
	public void delete(TCompany companies) {
		this.borrar(companies);
	}

	@Override
	public List<TCompany> getAll() {
		return this.buscar();
	}

	@Override
	public TCompany getCompanyById(Integer companyId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TCompany.class);

		criteria.add(Restrictions.eq(TCompany.FIELD_COMPANY_ID, companyId));

		return getTByCriteria(criteria);
	}

	@Override
	public List<TCompany> getCompaniesNoDefault() {

		DetachedCriteria criteria = DetachedCriteria.forClass(TCompany.class);

		criteria.add(Restrictions.ge("companyId", 0));

		return getListByCriteria(criteria);
	}

	/*@Override
	public void updateFlagIsEnable(Integer companyId, Integer isEnable) {

		Query query = getSession().createQuery(QUERY_UPDATE_FLAG_IS_ENABLE);

		query.setParameter(TCompany.FIELD_COMPANY_IS_DISABLE, isEnable);
		query.setParameter(TCompany.FIELD_COMPANY_ID, companyId);

		query.executeUpdate();
	}

	@Override
	public List<Integer> getCompaniesNotDisabled() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TCompany.class);
		criteria.add(Restrictions.eq(TCompany.FIELD_COMPANY_IS_DISABLE, CommonsConstants.ACTIVE_COMPANY));
		criteria.setProjection(Projections.property(TCompany.FIELD_COMPANY_ID));

		return getListIntegerByCriteria(criteria);
	}*/
}