package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.FormNewCampaignBean;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.dao.UserDAO;
import com.twobig.sivale.service.TCampaignsService;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TCampaignsServiceImpl implements TCampaignsService {

	@Autowired
	public RealUserCampaignDAO realUsersCampaignsDAO;

	@Autowired
	public CatClassificationCampaignDAO catClassificationCampaignDAO;

	@Autowired
	public TCampaignDAO tCampaignDAO;
	
	@Autowired
	public UserDAO userDAO;

	@Override
	public List<CampaignDetailBean> getCampaignByUserIdAndClassificationCampaignsId(int userId,
			int classificationCampaignsId) {

		List<RealUserCampaign> listA = realUsersCampaignsDAO.getRealUserCampaignByUserId(userId);

		List<Integer> campaignsByUser = new ArrayList<Integer>();

		for (RealUserCampaign listA2 : listA) {
			campaignsByUser.add(listA2.getCampaignId());
		}

		List<TCampaign> tCampaign = tCampaignDAO.getTCampaignByCampaignId(campaignsByUser);

		List<Integer> classificationId = new ArrayList<Integer>();
		
		

		for (TCampaign tCampaign2 : tCampaign) {

			classificationId.add(tCampaign2.getClassificationId());

		}
		
		List<CatClassificationCampaign> catClassificationCampaig =
				new ArrayList<CatClassificationCampaign>();
		
		for (Integer integer : classificationId) {
			
			catClassificationCampaig.add(
					catClassificationCampaignDAO.getCatClassificationCampaignById(integer));
			
		}
		
		
		System.out.println(catClassificationCampaig);

		// LIST FOR CampaignDetailBean
		List<CampaignDetailBean> listCampaignDetailBean = new ArrayList<CampaignDetailBean>();
		
		
		for(int i = 0; i < catClassificationCampaig.size(); i++){
			
			CatClassificationCampaign catClassificationCampaign = catClassificationCampaig.get(i);
			
			CampaignDetailBean campaignDetailBean = tCampaignToCampaignDetailBean(tCampaign.get(i));
			
			List<CatClassificationCampaign> listClassificationC = new ArrayList<CatClassificationCampaign>();

			List<String> listClassificationString = new ArrayList<String>();
			
			while (catClassificationCampaign.getLevel() > 0) {

				listClassificationC.add(catClassificationCampaign);
				listClassificationString.add(0, catClassificationCampaign.getClassName());
				Integer parentId = catClassificationCampaign.getCatClassificationCampaignsIdParent();

				catClassificationCampaign = catClassificationCampaignDAO
						.getCatClassificationCampaignById(parentId);
			}

			listClassificationC.add(catClassificationCampaign);
			listClassificationString.add(0, catClassificationCampaign.getClassName());

			if (catClassificationCampaign.getCatClassificationCampaignsId() == classificationCampaignsId) {
				
				campaignDetailBean.setCatClassificationCampaign(listClassificationC);
				campaignDetailBean.setClassification(listClassificationString);
				listCampaignDetailBean.add(campaignDetailBean);
			}
		}

		Collections.reverse(listCampaignDetailBean);
		
		return listCampaignDetailBean;
	}
	
	private CampaignDetailBean tCampaignToCampaignDetailBean(TCampaign tCampaign){
		
		CampaignDetailBean campaignDetailBean = new CampaignDetailBean();
		
		campaignDetailBean.setCampaignId(tCampaign.getCampaignId());
		
		campaignDetailBean.setCampaignName(tCampaign.getCampaignName());
		
		campaignDetailBean.setClassificationId(tCampaign.getClassificationId());
		
		campaignDetailBean.setDescription(tCampaign.getDescription());
		
		campaignDetailBean.setEndDate(tCampaign.getEndDate());
		
		campaignDetailBean.setStartDate(tCampaign.getStartDate());
		
		return campaignDetailBean; 	
	}

	@Override
	public List<CampaignDetailAdminBean> getCampaingsSuper(Integer userId) {
		
		TUser user = userDAO.getUserById(userId);
		
		List<TCampaign> listTCampaign = tCampaignDAO.getTCampaignByCompanyId(user.getCompany());
		
		List<Integer> classificationId = new ArrayList<Integer>();
		
		for (TCampaign tCampaign : listTCampaign) {
			
			classificationId.add(tCampaign.getClassificationId());
			
		}
		
		List<CatClassificationCampaign> catClassificationCampaig =
				new ArrayList<CatClassificationCampaign>();
		
		for (Integer integer : classificationId) {
			
			catClassificationCampaig.add(
					catClassificationCampaignDAO.getCatClassificationCampaignById(integer));
			
		}
		
		List<CampaignDetailAdminBean> listCampaignDetailAdminBean = 
				new ArrayList<CampaignDetailAdminBean>();
		
		for (int i = 0; i < catClassificationCampaig.size(); i++) {

			CatClassificationCampaign catClassificationCampaign = catClassificationCampaig.get(i);

			CampaignDetailAdminBean campaignDetailAdminBean = new CampaignDetailAdminBean();
			campaignDetailAdminBean.setTCampaign(listTCampaign.get(i));
			campaignDetailAdminBean.setTotalWon("$ 0.00");
			campaignDetailAdminBean.setTotalScattered("$ 0.00");
			campaignDetailAdminBean.setStatus(calculateStatus(listTCampaign.get(i).getStartDate(),
					listTCampaign.get(i).getEndDate()));

			List<String> listClassificationString = new ArrayList<String>();
			
			List<CatClassificationCampaign> ccc = new ArrayList<CatClassificationCampaign>();

			while (catClassificationCampaign.getLevel() > 0) {

				listClassificationString.add(0, catClassificationCampaign.getClassName());
				ccc.add(0, catClassificationCampaign);
				Integer parentId = catClassificationCampaign.getCatClassificationCampaignsIdParent();

				catClassificationCampaign = catClassificationCampaignDAO
						.getCatClassificationCampaignById(parentId);
			}

			listClassificationString.add(0, catClassificationCampaign.getClassName());
			ccc.add(0, catClassificationCampaign);
			campaignDetailAdminBean.setClassification(listClassificationString);
			campaignDetailAdminBean.setCatClassificationCampaign(ccc);
			listCampaignDetailAdminBean.add(campaignDetailAdminBean);
		}
		
		Collections.reverse(listCampaignDetailAdminBean);
		
		return listCampaignDetailAdminBean; 
	}
	
	private String calculateStatus(Date start, Date end){
		
		Date fechaActal = new Date();
		
		if(start == fechaActal || end == fechaActal){
			return "activa";
		}
		else if(start.before(fechaActal) && end.after(fechaActal)){
			return "activa";
		}
		else
			return "inactiva";
	}

	@Override
	public String insertCampaign(FormNewCampaignBean formNewCampaignBean) {
		
		TCampaign tCampaign = formNewCampaignBean.getTCampaign();
		
		Integer classificationId = insertClassificationCampaign(formNewCampaignBean);
				
		tCampaign.setClassificationId(classificationId);

		tCampaignDAO.insertTCampaign(tCampaign);
		
		System.out.println(tCampaign.toString());
		
		return null;
	}

	@Override
	public String updateCampaign(FormNewCampaignBean formNewCampaignBean) {
		
		TCampaign tCampaign = formNewCampaignBean.getTCampaign();
		
		Integer classificationId = insertClassificationCampaign(formNewCampaignBean);
				
		tCampaign.setClassificationId(classificationId);
		
		tCampaignDAO.updateTCampaign(tCampaign);
		
		System.out.println(tCampaign.toString());
		
		return null;
	}
	
	private Integer insertClassificationCampaign(FormNewCampaignBean formNewCampaignBean) {
		
		TCampaign tCampaign = formNewCampaignBean.getTCampaign();
		
		List <SelectClassificationCampaignBean> classificationList = 
				formNewCampaignBean.getClassificationList();
		
		Integer classificationId = classificationList.get(0).getId(); 
		
		for (SelectClassificationCampaignBean selectClassificationCampaignBean : classificationList) {
			if(selectClassificationCampaignBean.getId() > 0 ){
				classificationId = selectClassificationCampaignBean.getId(); 
			}
			else if(selectClassificationCampaignBean.getId() == -1){
				break;
			}
			else
				if(selectClassificationCampaignBean.getId() == -2){
					CatClassificationCampaign ccc = new CatClassificationCampaign();
					ccc.setClassName(selectClassificationCampaignBean.getName());
					ccc.setCompanyId(tCampaign.getCompanyId());
					ccc.setLevel(classificationList.indexOf(selectClassificationCampaignBean));
					ccc.setCatClassificationCampaignsIdParent(classificationId);
					catClassificationCampaignDAO.insertCatClassificationCampaign(ccc);
					classificationId = ccc.getCatClassificationCampaignsId();
				}
		}
		return classificationId;
	}

	@Override
	public String deleteCampaign(Integer campaignId) {
		TCampaign tCampaign = new TCampaign();
		tCampaign.setCampaignId(17);
		tCampaign.setCampaignId(campaignId);
		tCampaignDAO.deleteTCampaign(tCampaign);
		return null;
	}

}
