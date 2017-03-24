package com.twobig.sivale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.dao.UserDAO;
import com.twobig.sivale.service.TUserService;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TUserServiceImpl implements TUserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public List<TUser> getUsersByStars(List<String> listStars) {
		return userDAO.getUsersByStars(listStars);
	}

	@Override
	public TUser getUsersByStars(String stars) {
		return userDAO.getUsersByStars(stars);
	}

}
