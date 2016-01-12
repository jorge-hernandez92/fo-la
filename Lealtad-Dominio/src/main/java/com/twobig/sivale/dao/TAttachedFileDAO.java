package com.twobig.sivale.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.twobig.sivale.bd.to.TAttachedFile;

public interface TAttachedFileDAO {
	
	public List<TAttachedFile> getTAttachedFileByPublicationId(int publicationId);
	
	public void insertTAttachedFile(TAttachedFile tAttachedFile) throws DataIntegrityViolationException;
	
	public void updateTAttachedFile(TAttachedFile tAttachedFile);

}
