package com.companyname.service.dto.social;

import java.io.Serializable;

import com.companyname.service.dto.platform.PostDTO;

public class EventPostDTO extends PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String endDate;

	private String location;

	private String startDate;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "EventPostDTO [endDate=" + endDate + ", location=" + location + ", startDate=" + startDate + "]";
	}

}
