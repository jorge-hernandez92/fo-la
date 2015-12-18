package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.CatProfile;

public interface CatProfileDAO {

	public void insert(CatProfile catProfile);

	public void update(CatProfile catProfile);

	public void delete(CatProfile catProfile);

	public List<CatProfile> getAll();

	//public List<CatProfile> getCatProfilesByLevel(Integer level);

	public CatProfile getCatProfileByProfileId(Integer profileId);

	/**
	 * This method get the cat profile by id.
	 * 
	 * @param catProfileId
	 *            cat profile id.
	 * @return The cat profile object if was found, if was not found return
	 *         null.
	 */
	public CatProfile getCatProfilesById(int catProfileId);

	//public List<Integer> getCatProfilesMaxLevel(Integer level);

}