package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.TCompany;

public interface CompanyDAO {

	public static final String QUERY_UPDATE_FLAG_IS_ENABLE = "update TCompanies set isEnable = :isEnable where companyId = :companyId";

	public void insert(TCompany companies);

	public void update(TCompany companies);

	public void delete(TCompany companies);

	public List<TCompany> getAll();

	public TCompany getCompanyById(Integer companyId);
	
	public List<TCompany> getCompaniesNoDefault();
	

}
