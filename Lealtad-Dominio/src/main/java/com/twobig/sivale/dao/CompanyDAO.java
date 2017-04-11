package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.CatClient;

public interface CompanyDAO {

	void insert(CatClient companies);
	void update(CatClient companies);
	void delete(CatClient companies);
	List<CatClient> getAll();
	CatClient getCompanyById(Integer companyId);
	List<CatClient> getCompaniesNoDefault();

}
