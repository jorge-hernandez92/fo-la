package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.dao.UserDAO;
import com.twobig.sivale.service.CatClassificationCampaignService;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CatClassificationCampaignServiceImpl implements CatClassificationCampaignService {

	@Autowired
	public RealUserCampaignDAO realUsersCampaignsDAO;

	@Autowired
	public CatClassificationCampaignDAO catClassificationCampaignDAO;

	@Autowired
	public TCampaignDAO tCampaignDAO;
	
	@Autowired
	public UserDAO userDAO;

	/**
	 * Variable to register the logs.
	 */
	//private static final Logger logger = LogManager.getLogger(CatClassificationCampaignServiceImpl.class);

	@Override
	public List<CatClassificationCampaign> getCatClassificationCampaignByUserId(int userId) {
		
		List<CatClassificationCampaign> catClassificationCampaigParents = new ArrayList<CatClassificationCampaign>();

		List<RealUserCampaign> listA = realUsersCampaignsDAO.getRealUserCampaignByUserId(userId);

		List<Integer> campaignsByUser = new ArrayList<Integer>();

		for (RealUserCampaign listA2 : listA) {
			campaignsByUser.add(listA2.getCampaignId());
		}
		
		if(campaignsByUser.isEmpty()){
			return catClassificationCampaigParents; 
		}

		List<TCampaign> tCampaign = tCampaignDAO.getTCampaignByCampaignId(campaignsByUser);

		List<Integer> classificationId = new ArrayList<Integer>();

		for (TCampaign tCampaign2 : tCampaign) {

			classificationId.add(tCampaign2.getClassificationId());

		}

		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();

		linkedHashSet.addAll(classificationId);

		classificationId.clear();

		classificationId.addAll(linkedHashSet);

		List<CatClassificationCampaign> catClassificationCampaig = catClassificationCampaignDAO
				.getCatClassificationCampaignByClassificationId(classificationId);

		

		for (CatClassificationCampaign catClassificationCampaign : catClassificationCampaig) {

			while (catClassificationCampaign.getLevel() > 0) {

				Integer parentId = catClassificationCampaign.getCatClassificationCampaignsIdParent();

				catClassificationCampaign = catClassificationCampaignDAO
						.getCatClassificationCampaignById(parentId);
			}
			catClassificationCampaigParents.add(catClassificationCampaign);
		}

		Set<CatClassificationCampaign> linkedHashSet2 = new HashSet<CatClassificationCampaign>();

		linkedHashSet2.addAll(catClassificationCampaigParents);

		catClassificationCampaigParents.clear();

		catClassificationCampaigParents.addAll(linkedHashSet2);
		  
		return catClassificationCampaigParents;
	}

	@Override
	public List<SelectClassificationCampaignBean> getListClassificationChildren(int idParent) {
		
		List<CatClassificationCampaign> catClassificationCampaig = 
				catClassificationCampaignDAO.getListCatClassificationCampaignByParentId(idParent);
		 
		List<SelectClassificationCampaignBean> lsccb = new ArrayList<SelectClassificationCampaignBean>(); 
		for (CatClassificationCampaign catClassificationCampaign : catClassificationCampaig) {
			SelectClassificationCampaignBean sccb = new SelectClassificationCampaignBean();
			sccb.setId(catClassificationCampaign.getCatClassificationCampaignsId());
			sccb.setName(catClassificationCampaign.getClassName());
			lsccb.add(sccb);
			//logger.info(catClassificationCampaign.toString());
		}
		
		return lsccb;
	}

	@Override
	public List<SelectClassificationCampaignBean> getListClassificationParent(int userId) {
		
		TUser user = userDAO.getUserById(userId);
		
		List<CatClassificationCampaign> listClassification = 
				catClassificationCampaignDAO.getListCatClassificationCampaignByCompany(user.getCompany());
		
		List<SelectClassificationCampaignBean> lsccb = new ArrayList<SelectClassificationCampaignBean>(); 
		for (CatClassificationCampaign catClassificationCampaign : listClassification) {
			SelectClassificationCampaignBean sccb = new SelectClassificationCampaignBean();
			sccb.setId(catClassificationCampaign.getCatClassificationCampaignsId());
			sccb.setName(catClassificationCampaign.getClassName());
			lsccb.add(sccb);
			//logger.info(catClassificationCampaign.toString());
		}
		
		return lsccb;
	}
	
	
}
