package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TUser;

public interface TUserService {
	
	List<TUser> getUsersByStars(List<String> listStars);

}
