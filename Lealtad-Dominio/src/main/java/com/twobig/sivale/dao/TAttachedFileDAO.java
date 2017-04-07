package com.twobig.sivale.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.twobig.sivale.bd.to.TAttachedFile;

public interface TAttachedFileDAO {
	static final String QUERY_DELETE_ACUSE_FILE = "delete from TAttachedFile where isAcuse = 1";
	List<TAttachedFile> getTAttachedFileByPublicationId(int publicationId);
	void insertTAttachedFile(TAttachedFile tAttachedFile) throws DataIntegrityViolationException;
	void updateTAttachedFile(TAttachedFile tAttachedFile);
	void deleteTAttachedFile(TAttachedFile tAttachedFile);
	void deleteAcuseTAttachedFile();
	List<TAttachedFile> getListTAttachedFileByCampaignId(Integer campaignId);
}
