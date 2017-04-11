package com.twobig.sivale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClient;
import com.twobig.sivale.dao.CompanyDAO;
import com.twobig.sivale.service.CompanyService;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	public CompanyDAO companyDAO; 

	@Override
	public List<CatClient> getAllCompanies() {
		return companyDAO.getAll();
	}

}
