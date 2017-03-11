package com.twobig.sivale.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TCampaign;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignDetailBean extends TCampaign {
	
	private List<String> classification;
	
	private List<CatClassificationCampaign> catClassificationCampaign;
	
	private String imageBase64;
	
	private List<TAttachedFile> listTAttachedFile;

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	public List<String> getClassification() {
		return classification;
	}

	public void setClassification(List<String> classification) {
		this.classification = classification;
	}

	public List<CatClassificationCampaign> getCatClassificationCampaign() {
		return catClassificationCampaign;
	}

	public void setCatClassificationCampaign(List<CatClassificationCampaign> catClassificationCampaign) {
		this.catClassificationCampaign = catClassificationCampaign;
	}

	public List<TAttachedFile> getListTAttachedFile() {
		return listTAttachedFile;
	}
	
	public void setListTAttachedFile(List<TAttachedFile> listTAttachedFile) {
		this.listTAttachedFile = listTAttachedFile;
	}
	
}
