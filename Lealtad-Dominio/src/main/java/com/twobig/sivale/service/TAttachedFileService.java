package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TAttachedFile;

public interface TAttachedFileService {
	
	void insertTAttachedFile(TAttachedFile tAttachedFile);
	
	void insertTAttachedFile(List<TAttachedFile> tAttachedFileList);

}
