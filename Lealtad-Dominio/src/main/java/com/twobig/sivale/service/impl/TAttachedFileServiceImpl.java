package com.twobig.sivale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.dao.TAttachedFileDAO;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TAttachedFileServiceImpl implements com.twobig.sivale.service.TAttachedFileService {
	
	@Autowired
	public TAttachedFileDAO tAttachedFileDAO;

	@Override
	public void insertTAttachedFile(TAttachedFile tAttachedFile) {
		tAttachedFileDAO.insertTAttachedFile(tAttachedFile);

	}
	
	@Override
	public void insertTAttachedFile(List<TAttachedFile> tAttachedFileList){
		
		for (TAttachedFile tAttachedFile : tAttachedFileList) {
			tAttachedFileDAO.insertTAttachedFile(tAttachedFile);
		}
		
	}

	@Override
	public List<TAttachedFile> getListTAttachedFile(Integer campaignId) {
		return tAttachedFileDAO.getListTAttachedFileByCampaignId(campaignId);
	}

}
