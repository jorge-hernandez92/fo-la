package com.twobig.sivale.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.twobig.sivale.bd.to.TAttachedFile;

public interface TAttachedFileDAO {
	
	List<TAttachedFile> getTAttachedFileByPublicationId(int publicationId);
	
	void insertTAttachedFile(TAttachedFile tAttachedFile) throws DataIntegrityViolationException;
	
	void updateTAttachedFile(TAttachedFile tAttachedFile);
	
	void deleteTAttachedFile(TAttachedFile tAttachedFile);
	
	List<TAttachedFile> getListTAttachedFileByCampaignId(Integer campaignId);
}
