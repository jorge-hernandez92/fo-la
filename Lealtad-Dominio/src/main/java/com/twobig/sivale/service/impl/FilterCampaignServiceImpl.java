package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.SearchCampaignBean;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.service.FilterCampaignService;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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

		List<CatClassificationCampaign> catClassificationCampaig = new ArrayList<CatClassificationCampaign>();

		for (Integer integer : classificationId) {

			catClassificationCampaig.add(catClassificationCampaignDAO.getCatClassificationCampaignById(integer));

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

				catClassificationCampaign = catClassificationCampaignDAO.getCatClassificationCampaignById(parentId);
			}

			listClassificationC.add(catClassificationCampaign);

			listClassificationString.add(0, catClassificationCampaign.getClassName());

			if (catClassificationCampaign.getCatClassificationCampaignsId() == searchCampaignBean
					.getClassificationParentId()) {

				if (exist(searchCampaignBean.getClassificationName1())
						&& exist(searchCampaignBean.getClassificationName2())) {

					if (contains(listClassificationString, searchCampaignBean.getClassificationName1())
							&& contains(listClassificationString, searchCampaignBean.getClassificationName2())) {

						campaignDetailBean.setClassification(listClassificationString);

						campaignDetailBean.setCatClassificationCampaign(listClassificationC);

						listCampaignDetailBean.add(campaignDetailBean);
					}
				} else if (exist(searchCampaignBean.getClassificationName1())) {
					if (contains(listClassificationString, searchCampaignBean.getClassificationName1())) {

						campaignDetailBean.setClassification(listClassificationString);

						campaignDetailBean.setCatClassificationCampaign(listClassificationC);

						listCampaignDetailBean.add(campaignDetailBean);
					}
				} else if (exist(searchCampaignBean.getClassificationName2())) {
					if (contains(listClassificationString, searchCampaignBean.getClassificationName2())) {

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

	private Boolean contains(List<String> listString, String cadena) {
		for (String string : listString)
			if (string.toLowerCase().indexOf(cadena.trim().toLowerCase()) != -1)
				return true;
		return false;
	}

	private Boolean exist(String classificationName) {
		return (classificationName != null && !classificationName.trim().isEmpty());
	}

	private CampaignDetailBean tCampaignToCampaignDetailBean(TCampaign tCampaign) {

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
	public List<CampaignDetailAdminBean> FilterCampaignAdmin(int companyId, SearchCampaignBean searchCampaignBean) {

		searchCampaignBean.getClassificationParentId();

		List<TCampaign> listTCampaigns = tCampaignDAO.getTCampaignByCompanyIdCampaignNameAndDate(companyId,
				searchCampaignBean.getCampaignName().trim(), searchCampaignBean.getStartDate(),
				searchCampaignBean.getEndDate());

		List<Integer> classificationId = new ArrayList<Integer>();

		for (TCampaign tCampaign : listTCampaigns) {

			classificationId.add(tCampaign.getClassificationId());

		}

		List<CatClassificationCampaign> catClassificationCampaig = new ArrayList<CatClassificationCampaign>();

		for (Integer integer : classificationId) {

			catClassificationCampaig.add(catClassificationCampaignDAO.getCatClassificationCampaignById(integer));

		}

		List<CampaignDetailAdminBean> listCampaignDetailAdminBean = new ArrayList<CampaignDetailAdminBean>();

		for (int i = 0; i < catClassificationCampaig.size(); i++) {

			CatClassificationCampaign catClassificationCampaign = catClassificationCampaig.get(i);

			CampaignDetailAdminBean campaignDetailAdminBean = new CampaignDetailAdminBean();
			campaignDetailAdminBean.setTCampaign(listTCampaigns.get(i));
			campaignDetailAdminBean.setTotalWon("$ 0.00");
			campaignDetailAdminBean.setTotalScattered("$ 0.00");

			campaignDetailAdminBean.setStatus(
					calculateStatus(listTCampaigns.get(i).getStartDate(), listTCampaigns.get(i).getEndDate()));

			List<CatClassificationCampaign> listClassificationC = new ArrayList<CatClassificationCampaign>();
			List<String> listClassificationString = new ArrayList<String>();

			while (catClassificationCampaign.getLevel() > 0) {

				listClassificationC.add(catClassificationCampaign);

				listClassificationString.add(0, catClassificationCampaign.getClassName());

				Integer parentId = catClassificationCampaign.getCatClassificationCampaignsIdParent();

				catClassificationCampaign = catClassificationCampaignDAO.getCatClassificationCampaignById(parentId);
			}

			listClassificationC.add(catClassificationCampaign);

			listClassificationString.add(0, catClassificationCampaign.getClassName());

			if (searchCampaignBean.getCompany() != null && !searchCampaignBean.getCompany().isEmpty()) {
				if (catClassificationCampaign.getClassName().toLowerCase()
						.indexOf(searchCampaignBean.getCompany().trim().toLowerCase()) != -1) {

					addIfExist(searchCampaignBean, listClassificationString, listClassificationC,
							campaignDetailAdminBean, listCampaignDetailAdminBean);
				}
			} else {

				addIfExist(searchCampaignBean, listClassificationString, listClassificationC, campaignDetailAdminBean,
						listCampaignDetailAdminBean);
			}
		}
		return listCampaignDetailAdminBean;
	}

	private void addIfExist(SearchCampaignBean searchCampaignBean, List<String> listClassificationString,
			List<CatClassificationCampaign> listClassificationC, CampaignDetailAdminBean campaignDetailAdminBean,
			List<CampaignDetailAdminBean> listCampaignDetailAdminBean) {

		if (exist(searchCampaignBean.getClassificationName1()) && exist(searchCampaignBean.getClassificationName2())) {

			if (contains(listClassificationString, searchCampaignBean.getClassificationName1())
					&& contains(listClassificationString, searchCampaignBean.getClassificationName2())) {

				campaignDetailAdminBean.setClassification(listClassificationString);
				campaignDetailAdminBean.setCatClassificationCampaign(listClassificationC);
				listCampaignDetailAdminBean.add(campaignDetailAdminBean);

			}
		} else if (exist(searchCampaignBean.getClassificationName1())) {
			if (contains(listClassificationString, searchCampaignBean.getClassificationName1())) {

				campaignDetailAdminBean.setClassification(listClassificationString);
				campaignDetailAdminBean.setCatClassificationCampaign(listClassificationC);
				listCampaignDetailAdminBean.add(campaignDetailAdminBean);

			}
		} else if (exist(searchCampaignBean.getClassificationName2())) {
			if (contains(listClassificationString, searchCampaignBean.getClassificationName2())) {

				campaignDetailAdminBean.setClassification(listClassificationString);
				campaignDetailAdminBean.setCatClassificationCampaign(listClassificationC);
				listCampaignDetailAdminBean.add(campaignDetailAdminBean);

			}
		} else {

			campaignDetailAdminBean.setClassification(listClassificationString);
			campaignDetailAdminBean.setCatClassificationCampaign(listClassificationC);
			listCampaignDetailAdminBean.add(campaignDetailAdminBean);

		}
	}

	private String calculateStatus(Date start, Date end) {

		Date fechaActal = new Date();

		if (start == fechaActal || end == fechaActal) {
			return "activa";
		} else if (start.before(fechaActal) && end.after(fechaActal)) {
			return "activa";
		} else
			return "inactiva";
	}

}
