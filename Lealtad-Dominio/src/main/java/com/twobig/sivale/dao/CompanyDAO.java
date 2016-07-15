package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.CatClient;

public interface CompanyDAO {

	public static final String QUERY_UPDATE_FLAG_IS_ENABLE = "update TCompanies set isEnable = :isEnable where companyId = :companyId";

	public void insert(CatClient companies);

	public void update(CatClient companies);

	public void delete(CatClient companies);

	public List<CatClient> getAll();

	public CatClient getCompanyById(Integer companyId);
	
	public List<CatClient> getCompaniesNoDefault();
	

}
