package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.PublicationCRUDBean;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TAttachedFileDAO;
import com.twobig.sivale.dao.TPublicationDAO;
import com.twobig.sivale.service.TPublicationService;

@Service
public class TPublicationServiceImpl implements TPublicationService {

	@Autowired
	public RealUserCampaignDAO realUserCampaignDAO;

	@Autowired
	public TPublicationDAO tPublicationDAO;

	@Autowired
	public TAttachedFileDAO tAttachedFileDAO;

	// QUITAR ESTE METODO
	@Override
	public List<TPublication> getTPublicationByUserIdAndCampaignId(int userId, int campaignId) {

		List<RealUserCampaign> listA = realUserCampaignDAO.getRealUserCampaignByUserId(userId);

		List<Integer> campaignsByUser = new ArrayList<Integer>();

		for (RealUserCampaign listA2 : listA) {
			campaignsByUser.add(listA2.getCampaignId());
		}

		List<TPublication> publicaciones = tPublicationDAO.getTCampaignByPublicationId(campaignsByUser);

		return publicaciones;
	}

	@Override
	public List<TPublication> getTPublicationCampaignId(int campaignId) {

		List<TPublication> publicaciones = tPublicationDAO.getTCampaignByPublicationId(campaignId);

		return publicaciones;
	}

	@Override
	public String addPublication(PublicationCRUDBean publicationInsertBean) {

		String status = "";

		tPublicationDAO.insertPublication(publicationInsertBean.getPublication());

		if (publicationInsertBean.getPublication().getPublicationId() != 0) {
			status += " . Se insertó: " + publicationInsertBean.getPublication().toString();
		} else {
			status += " . No se insertó: " + publicationInsertBean.getPublication().toString();
		}

		Integer publicationId = publicationInsertBean.getPublication().getPublicationId();

		for (TAttachedFile attachedFile : publicationInsertBean.getAttachedFiles()) {

			attachedFile.settPublicationId(publicationId);
			tAttachedFileDAO.insertTAttachedFile(attachedFile);

			if (attachedFile.getAttachedFileId() != 0) {
				status += "\n . Se insertó: " + attachedFile.toString();
			} else {
				status += "\n . No se insertó: " + attachedFile.toString();
			}
		}

		return status;
	}

	public String updatePublication(PublicationCRUDBean publicationInsertBean) {

		String status = "";

		if (publicationInsertBean.getPublication().getPublicationId() != 0) {
			tPublicationDAO.updatePublication(publicationInsertBean.getPublication());
			status += " . Se actualizó: " + publicationInsertBean.getPublication().toString();
		} else {
			status += " . No se actualizó: " + publicationInsertBean.getPublication().toString();
		}

		for (TAttachedFile attachedFile : publicationInsertBean.getAttachedFiles()) {

			if (attachedFile.getAttachedFileId() != 0) {
				tAttachedFileDAO.updateTAttachedFile(attachedFile);
				status += "\n . Se actualizó: " + attachedFile.toString();
			} else {
				status += "\n . No se actualizó: " + attachedFile.toString();
			}
		}

		return status;
	}

	@Override
	public String deletePublication(Integer publicationId) {
		TPublication publication = new TPublication();
		publication.setPublicationId(publicationId);
		tPublicationDAO.deletePublication(publication);
		return null; 
	}

}