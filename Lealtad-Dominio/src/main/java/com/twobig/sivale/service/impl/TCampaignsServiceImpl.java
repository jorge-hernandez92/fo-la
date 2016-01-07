package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.service.TCampaignsService;

@Service
public class TCampaignsServiceImpl implements TCampaignsService {

	@Autowired
	public RealUserCampaignDAO realUsersCampaignsDAO;

	@Autowired
	public CatClassificationCampaignDAO catClassificationCampaignDAO;

	@Autowired
	public TCampaignDAO tCampaignDAO;

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
						.getCatClassificationCampaignByParentId(parentId);
			}

			listClassificationC.add(catClassificationCampaign);
			
			listClassificationString.add(0, catClassificationCampaign.getClassName());

			if (catClassificationCampaign.getCatClassificationCampaignsId() == classificationCampaignsId) {
				
				campaignDetailBean.setCatClassificationCampaign(listClassificationC);
				
				campaignDetailBean.setClassification(listClassificationString);
				
				listCampaignDetailBean.add(campaignDetailBean);
			}
		}

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
}
