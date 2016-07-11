package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.Client;

public interface CompanyDAO {

	public static final String QUERY_UPDATE_FLAG_IS_ENABLE = "update TCompanies set isEnable = :isEnable where companyId = :companyId";

	public void insert(Client companies);

	public void update(Client companies);

	public void delete(Client companies);

	public List<Client> getAll();

	public Client getCompanyById(Integer companyId);
	
	public List<Client> getCompaniesNoDefault();
	

}
