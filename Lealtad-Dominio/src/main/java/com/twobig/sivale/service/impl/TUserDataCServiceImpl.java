package com.twobig.sivale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.TUserDataC;
import com.twobig.sivale.dao.TUserDataCDAO;
import com.twobig.sivale.service.TUserDataCService;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TUserDataCServiceImpl implements TUserDataCService {
	
	@Autowired
	public TUserDataCDAO tUserDataCDAO;

	@Override
	public void insertTUserData(TUserDataC tUserDataC) {
		tUserDataCDAO.insertTUserData(tUserDataC);
	}

}
