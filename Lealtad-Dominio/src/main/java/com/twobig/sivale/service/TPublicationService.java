package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.CatPublicationType;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.PublicationCRUDBean;

public interface TPublicationService {

	
	public List<TPublication> getTPublicationByUserIdAndCampaignId(int userId, int campaignId);

	public List<TPublication> getTPublicationCampaignId(int campaignId, int profile);

	public String addPublication(PublicationCRUDBean publicationInsertBean);

	public String updatePublication(PublicationCRUDBean publicationInsertBean);
	
	public String deletePublication(Integer publicationId);
	
	public List<CatPublicationType> getPublicationType();
	
	public void updateExcel(TPublication publication, String path);
	
	public void changeStatusPublication(TPublication publication);
	
	public void insertListAttachedFiles(List<TAttachedFile> listAttachedFile);
	
	public void deleteListAttachedFiles(List<TAttachedFile> listAttachedFile);
	
	public void updateListAttachedFiles(List<TAttachedFile> listAttachedFile);
	
	public void loadDataExcel(int publicationId, String path);
	
	TPublication getPublicationById(Integer idTPublication);
	
	List<TPublication> getTPublicationAdminCampaignId(int campaignId, int profile);
}
