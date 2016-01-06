package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.TAttachedFile;

public interface TAttachedFileDAO {
	
	public List<TAttachedFile> getTAttachedFileByPublicationId(int publicationId);

}
