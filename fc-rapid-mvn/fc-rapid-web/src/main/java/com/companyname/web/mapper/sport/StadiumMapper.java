package com.companyname.web.mapper.sport;

import org.springframework.stereotype.Component;

import com.companyname.service.dto.sport.StadiumDTO;
import com.companyname.web.model.sport.StadiumModel;

@Component
public class StadiumMapper {

	public StadiumDTO mapDto(StadiumModel stadiumModel) {
		StadiumDTO stadiumDto = new StadiumDTO();
		return stadiumDto;
	}

}
