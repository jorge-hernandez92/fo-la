package com.twobig.sivale.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCampaignBean {

	private List<SelectClassificationCampaignBean> availableOptions;

	private SelectClassificationCampaignBean selectedOption;

	public List<SelectClassificationCampaignBean> getAvailableOptions() {
		return availableOptions;
	}

	public void setAvailableOptions(List<SelectClassificationCampaignBean> availableOptions) {
		this.availableOptions = availableOptions;
	}

	public SelectClassificationCampaignBean getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(SelectClassificationCampaignBean selectedOption) {
		this.selectedOption = selectedOption;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("availableOptions", availableOptions)
				.add("selectedOption", selectedOption).toString();
	}
	
}
