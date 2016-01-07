package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.SearchCampaignBean;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.service.FilterCampaignService;

@Service
public class FilterCampaignServiceImpl implements FilterCampaignService {

	@Autowired
	public RealUserCampaignDAO realUsersCampaignsDAO;

	@Autowired
	public TCampaignDAO tCampaignDAO;
	
	@Autowired
	public CatClassificationCampaignDAO catClassificationCampaignDAO;

	@Override
	public List<CampaignDetailBean> FilterCampaign(int userId, SearchCampaignBean searchCampaignBean) {

		List<RealUserCampaign> listA = realUsersCampaignsDAO.getRealUserCampaignByUserId(userId);

		List<Integer> listCampaigns = new ArrayList<Integer>();

		for (RealUserCampaign listA2 : listA) {

			listCampaigns.add(listA2.getCampaignId());

		}

		List<TCampaign> listTCampaigns = tCampaignDAO.getTCampaignByCampaignIdCampaignNameAndDate(listCampaigns,
				searchCampaignBean.getCampaignName().trim(), searchCampaignBean.getStartDate(),
				searchCampaignBean.getEndDate());
		
		List<Integer> classificationId = new ArrayList<Integer>();

		for (TCampaign tCampaign : listTCampaigns) {

			classificationId.add(tCampaign.getClassificationId());

		}
		
		List<CatClassificationCampaign> catClassificationCampaig =
				new ArrayList<CatClassificationCampaign>();
		
		for (Integer integer : classificationId) {
			
			catClassificationCampaig.add(
					catClassificationCampaignDAO.getCatClassificationCampaignById(integer));
			
		}
		
		// LIST FOR CampaignDetailBean
		List<CampaignDetailBean> listCampaignDetailBean = new ArrayList<CampaignDetailBean>();

		for (int i = 0; i < catClassificationCampaig.size(); i++) {

			CatClassificationCampaign catClassificationCampaign = catClassificationCampaig.get(i);

			CampaignDetailBean campaignDetailBean = tCampaignToCampaignDetailBean(listTCampaigns.get(i));

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
			
			if (catClassificationCampaign.getCatClassificationCampaignsId() == searchCampaignBean
					.getClassificationParentId()) {

				if (searchCampaignBean.getClassificationName1() != null
						&& searchCampaignBean.getClassificationName2() != null) {

					if (listClassificationString.contains(searchCampaignBean.getClassificationName1().trim())
							&& listClassificationString.contains(searchCampaignBean.getClassificationName2().trim())) {
						
						campaignDetailBean.setClassification(listClassificationString);
						
						campaignDetailBean.setCatClassificationCampaign(listClassificationC);
						
						listCampaignDetailBean.add(campaignDetailBean);
					}
				} else if (searchCampaignBean.getClassificationName1() != null) {
					if (listClassificationString.contains(searchCampaignBean.getClassificationName1().trim())) {
						
						campaignDetailBean.setClassification(listClassificationString);
						
						campaignDetailBean.setCatClassificationCampaign(listClassificationC);
						
						listCampaignDetailBean.add(campaignDetailBean);
					}
				} else if (searchCampaignBean.getClassificationName2() != null) {
					if (listClassificationString.contains(searchCampaignBean.getClassificationName2().trim())) {
						
						campaignDetailBean.setClassification(listClassificationString);
						
						campaignDetailBean.setCatClassificationCampaign(listClassificationC);
						
						listCampaignDetailBean.add(campaignDetailBean);
					}
				} else {
					
					campaignDetailBean.setClassification(listClassificationString);
					
					campaignDetailBean.setCatClassificationCampaign(listClassificationC);
					
					listCampaignDetailBean.add(campaignDetailBean);
				}
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
