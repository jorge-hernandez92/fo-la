package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.RealUserCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;
import com.twobig.sivale.dao.RealUserCampaignDAO;
import com.twobig.sivale.dao.TCampaignDAO;
import com.twobig.sivale.service.CatClassificationCampaignService;

@Service
public class CatClassificationCampaignServiceImpl implements CatClassificationCampaignService {

	@Autowired
	public RealUserCampaignDAO realUsersCampaignsDAO;

	@Autowired
	public CatClassificationCampaignDAO catClassificationCampaignDAO;

	@Autowired
	public TCampaignDAO tCampaignDAO;

	/**
	 * Variable to register the logs.
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(CatClassificationCampaignServiceImpl.class);

	@Override
	public List<CatClassificationCampaign> getCatClassificationCampaignByUserId(int userId) {

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

		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();

		linkedHashSet.addAll(classificationId);

		classificationId.clear();

		classificationId.addAll(linkedHashSet);

		List<CatClassificationCampaign> catClassificationCampaig = catClassificationCampaignDAO
				.getCatClassificationCampaignByClassificationId(classificationId);

		List<CatClassificationCampaign> catClassificationCampaigParents = new ArrayList<CatClassificationCampaign>();

		for (CatClassificationCampaign catClassificationCampaign : catClassificationCampaig) {

			while (catClassificationCampaign.getLevel() > 0) {

				Integer parentId = catClassificationCampaign.getCatClassificationCampaignsIdParent();

				catClassificationCampaign = catClassificationCampaignDAO
						.getCatClassificationCampaignByParentId(parentId);
			}
			catClassificationCampaigParents.add(catClassificationCampaign);
		}

		return catClassificationCampaigParents;
	}
}
