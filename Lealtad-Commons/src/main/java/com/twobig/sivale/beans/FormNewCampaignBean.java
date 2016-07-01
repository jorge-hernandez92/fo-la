package com.twobig.sivale.beans;

import java.io.File;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.twobig.sivale.bd.to.TCampaign;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FormNewCampaignBean extends TCampaign{
	

	private static final long serialVersionUID = 3601724606818514826L;
	private List <SelectClassificationCampaignBean> classificationList;
	private String imageFile; 
	private String nameFile; 

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public String getImageFile() {	
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public List<SelectClassificationCampaignBean> getClassificationList() {
		return classificationList;
	}

	public void setClassificationList(List<SelectClassificationCampaignBean> classificationList) {
		this.classificationList = classificationList;
	}
	
	
	public TCampaign getTCampaign(){
		TCampaign tCampaign = new TCampaign();
		tCampaign.setCampaignId(this.getCampaignId());
		tCampaign.setCampaignName(this.getCampaignName());
		tCampaign.setClassificationId(this.getClassificationId());
		tCampaign.setCompanyId(this.getCompanyId());
		tCampaign.setDescription(this.getDescription());
		tCampaign.setEndDate(this.getEndDate());
		tCampaign.setStartDate(this.getStartDate());
		return tCampaign;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("super", super.toString())
				.add("classificationList", classificationList).toString();
	}
	
}
