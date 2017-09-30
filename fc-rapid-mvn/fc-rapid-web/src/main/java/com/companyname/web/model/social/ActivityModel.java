package com.companyname.web.model.social;

public class ActivityModel {

	private String activityDescription;

	private String activityDate;

	private String activityTitle;

	private String activityUrl;

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

	@Override
	public String toString() {
		return "ActivityModel [activityDescription=" + activityDescription + ", activityDate=" + activityDate
				+ ", activityTitle=" + activityTitle + ", activityUrl=" + activityUrl + "]";
	}

}
