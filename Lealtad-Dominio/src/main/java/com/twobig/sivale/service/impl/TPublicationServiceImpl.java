package com.twobig.sivale.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatPublicationType;
import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.bd.to.TUserData;
import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.beans.ExcelDataUserBean;
import com.twobig.sivale.beans.PublicationCRUDBean;
import com.twobig.sivale.constants.CommonsConstants;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.dao.CatPublicationTypeDAO;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TAttachedFileDAO;
import com.twobig.sivale.dao.TPublicationDAO;
import com.twobig.sivale.dao.TUserDataDAO;
import com.twobig.sivale.dao.UserDAO;
import com.twobig.sivale.service.TPublicationService;
import com.twobig.sivale.utils.ImageUtils;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TPublicationServiceImpl implements TPublicationService {

	@Autowired
	public RealUserCampaignDAO realUserCampaignDAO;

	@Autowired
	public TPublicationDAO tPublicationDAO;

	@Autowired
	public TAttachedFileDAO tAttachedFileDAO;
	
	@Autowired
	public UserDAO userDAO; 
	
	@Autowired
	public CatPublicationTypeDAO publicationTypeDAO;
	
	@Autowired
	public TUserDataDAO tUserDataDAO;
	
	private static final Logger logger = LogManager.getLogger(TPublicationServiceImpl.class);
	
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
	public List<TPublication> getTPublicationCampaignId(int campaignId, int profile) {

		List<TPublication> publicaciones = tPublicationDAO.getTCampaignByPublicationId(campaignId, profile);
		
		for (TPublication tPublication : publicaciones) {
			if(tPublication.getImagePath() != null){ 
				
				/* SET IMAGE64 for TCAMPAIGN ICON*/
				String pathImage = PathConstants.ATTACHED_DIRECTORY + campaignId+File.separator+tPublication.getPublicationId() + File.separator + tPublication.getImagePath();
				
				ImageUtils imageUtils = new ImageUtils();

				try {
					String image64 = imageUtils.imageToBase64(pathImage);
					/*This have to change with a DTO*/
					tPublication.setImagePath("data:image/png;base64,"+image64);
					logger.info(image64);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.info("ERROR AL CARGAR IMAGEN DE CAMPAÑA DEL SISTEMA DE ARCHIVOS");
					e.printStackTrace();
				}
				
			}
			else{
				logger.info("NO HAY IMAGEN PARA ESTA CAMPAÑA: "+tPublication.toString());
			}
		}	
		return publicaciones;
	}
	
	@Override
	public List<TPublication> getTPublicationAdminCampaignId(int campaignId, int profile){
		
		List<TPublication> publicaciones = tPublicationDAO.getTCampaignByPublicationId(campaignId, profile);
		
		return publicaciones;
	}

	@Override
	public String addPublication(PublicationCRUDBean publicationInsertBean) {

		String status = "";

		publicationInsertBean.getPublication().setPublishedDate(new Date());

		tPublicationDAO.insertPublication(publicationInsertBean.getPublication());

		if (publicationInsertBean.getPublication().getPublicationId() != 0) {
			
			status += " . Se insertó: " + publicationInsertBean.getPublication().toString();
			
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
			
			return ""+publicationInsertBean.getPublication().getPublicationId(); 
			
		} else {
			status += " . No se insertó: " + publicationInsertBean.getPublication().toString();
			return status; 
		}
	}
	
	@Override
	public String updatePublication(PublicationCRUDBean publicationInsertBean) {

		String status = updatePublicationOnly(publicationInsertBean.getPublication());
		
		return status;
	}
	
	private String updatePublicationOnly(TPublication publication){
		
		String status = "";

		if (publication.getPublicationId() != 0) {
			tPublicationDAO.updatePublication(publication);
			status = "SUCCESS";
		} else {
			status = "ERROR";
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

	@Override
	public List<CatPublicationType> getPublicationType() {
		
		return publicationTypeDAO.getAllCatPublicationType();
	}
	
	@Override
	public void updateExcel(TPublication publication, String path) {
		deleteDataExcel(publication.getPublicationId());
		loadDataExcel(publication.getPublicationId(), path);
	}

	private void deleteDataExcel(int publicationId){
		TUserData tUserData = new TUserData();
		tUserData.setPublicationId(publicationId);
		tUserDataDAO.deleteTUserData(tUserData);
	}

	
	@Override
	public void loadDataExcel(int publicationId, String path){
		TPublication publication = new TPublication();
		publication.setPublicationId(publicationId);
		publication.setDataFilePath(path);
		loadDataExcel(publication);
	}
	
 	private void loadDataExcel(TPublication publication) {
		
		ExcelServiceImpl excelservice = new ExcelServiceImpl();
		ExcelBean excelBean = excelservice.getExcelData(publication.getDataFilePath());
		List<ExcelDataUserBean> dataList = excelservice.getFormatList(excelBean, CommonsConstants.COLUMN_ID_EXCEL);
		
		List<String> listAccountNumber = new ArrayList<String>();
		
		for (ExcelDataUserBean excelDataUserBean : dataList) {
			listAccountNumber.add(excelDataUserBean.getUserId());
		}
		
		List<TUser> listUser= userDAO.getListUserByAccountNumber(listAccountNumber);
		
		for (TUser tUser : listUser) {
			
			int index = listAccountNumber.indexOf(tUser.getTjAccountNumber());
			
			ExcelDataUserBean excelDataUserBean = dataList.get(index);
			
			TUserData tUserData = new TUserData();
			tUserData.setData(excelDataUserBean.getData());
			tUserData.setUserId(tUser.getUserId());
			tUserData.setPublicationId(publication.getPublicationId());
			
			tUserDataDAO.insertTUserData(tUserData);
		}
	}

	@Override
	public void changeStatusPublication(TPublication publication) {
		updatePublicationOnly(publication);
	}

	@Override
	public void insertListAttachedFiles(List<TAttachedFile> listAttachedFile) {
		for (TAttachedFile tAttachedFile : listAttachedFile) {
			tAttachedFileDAO.insertTAttachedFile(tAttachedFile);
		}
	}

	@Override
	public void deleteListAttachedFiles(List<TAttachedFile> listAttachedFile) {
		for (TAttachedFile tAttachedFile : listAttachedFile) {
			tAttachedFileDAO.deleteTAttachedFile(tAttachedFile);
		}
	}

	@Override
	public void updateListAttachedFiles(List<TAttachedFile> listAttachedFile) {
		for (TAttachedFile tAttachedFile : listAttachedFile) {
			tAttachedFileDAO.updateTAttachedFile(tAttachedFile);
		}
	}
	
	@Override
	public TPublication getPublicationById(Integer idTPublication){
		return tPublicationDAO.getPublicationById(idTPublication);
	}
}