package com.twobig.sivale.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.twobig.sivale.bd.to.TCampaign;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FormNewCampaignBean extends TCampaign{
	
	private List <SelectClassificationCampaignBean> classificationList;

	public List<SelectClassificationCampaignBean> getClassificationList() {
		return classificationList;
	}

	public void setClassificationList(List<SelectClassificationCampaignBean> classificationList) {
		this.classificationList = classificationList;
	}

}
