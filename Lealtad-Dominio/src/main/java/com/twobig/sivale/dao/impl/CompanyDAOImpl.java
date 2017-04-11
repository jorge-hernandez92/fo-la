package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.CatClient;
import com.twobig.sivale.dao.CompanyDAO;

import com.twobig.sivale.dao.impl.GenericDAOImpl;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyDAOImpl extends GenericDAOImpl<CatClient, Long> implements
		CompanyDAO {

	public CompanyDAOImpl() {
		super(CatClient.class);
	}

	@Override
	public void insert(CatClient companies) {
		this.guardar(companies);
	}

	@Override
	public void update(CatClient companies) {
		this.actualizar(companies);
	}

	@Override
	public void delete(CatClient companies) {
		this.borrar(companies);
	}

	@Override
	public List<CatClient> getAll() {
		return this.buscar();
	}

	@Override
	public CatClient getCompanyById(Integer companyId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CatClient.class);
		criteria.add(Restrictions.eq(CatClient.FIELD_COMPANY_ID, companyId));
		return getTByCriteria(criteria);
	}

	@Override
	public List<CatClient> getCompaniesNoDefault() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CatClient.class);
		criteria.add(Restrictions.ge("companyId", 0));
		return getListByCriteria(criteria);
	}
}