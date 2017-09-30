package com.companyname.service.transformer.sport;

import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.sport.Stadium;
import com.companyname.service.dto.sport.StadiumDTO;

@Component
public class StadiumTransformer {

	public Stadium toEntity(StadiumDTO stadiumDto) {
		return new Stadium();
	}

}
