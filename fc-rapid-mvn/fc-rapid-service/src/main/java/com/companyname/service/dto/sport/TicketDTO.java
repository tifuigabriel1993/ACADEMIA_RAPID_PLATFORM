package com.companyname.service.dto.sport;

import java.io.Serializable;

import com.companyname.service.dto.platform.MatchDTO;

public class TicketDTO implements Serializable {

	private static final long serialVersionUID = 7156193166643162648L;

	private MatchDTO match;

	private String externalSource;

	public MatchDTO getMatch() {
		return match;
	}

	public void setMatch(MatchDTO match) {
		this.match = match;
	}

	public String getExternalSource() {
		return externalSource;
	}

	public void setExternalSource(String externalSource) {
		this.externalSource = externalSource;
	}

	@Override
	public String toString() {
		return "TicketDTO [match=" + match + ", externalSource=" + externalSource + "]";
	}

}
