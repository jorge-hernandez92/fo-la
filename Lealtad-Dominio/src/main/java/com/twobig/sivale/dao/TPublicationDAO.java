package com.twobig.sivale.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.twobig.sivale.bd.to.TPublication;

public interface TPublicationDAO {
	
	public List<TPublication> getTCampaignByPublicationId(List<Integer> publicationId);

	public TPublication getPublicationById(int publicationId);
	
	public List<TPublication> getTCampaignByPublicationId(int campaign);
	
	public void insertPublication(TPublication tPublication) throws DataIntegrityViolationException;
	
	public void updatePublication(TPublication tPublication);

}
