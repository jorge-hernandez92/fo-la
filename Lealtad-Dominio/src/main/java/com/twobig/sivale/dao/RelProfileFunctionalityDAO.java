package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.RelProfileFunctionality;

public interface RelProfileFunctionalityDAO {

	public List<RelProfileFunctionality> getRelProfileFunctionalityByCatProfile(int catProfileId);
}
