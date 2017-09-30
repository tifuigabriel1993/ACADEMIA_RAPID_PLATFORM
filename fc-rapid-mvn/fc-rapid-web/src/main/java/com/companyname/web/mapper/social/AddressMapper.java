package com.companyname.web.mapper.social;

import org.springframework.stereotype.Component;

import com.companyname.service.dto.platform.AddressDTO;
import com.companyname.web.model.social.AddressModel;

@Component
public class AddressMapper {

	public AddressDTO mapDto(AddressModel addressModel) {
		AddressDTO addressDto = new AddressDTO();
		addressDto.setCountry(addressModel.getCountry());
		addressDto.setCity(addressModel.getCity());
		return addressDto;
	}

	public AddressModel mapModel(AddressDTO addressDTO) {
		AddressModel addressModel = new AddressModel();
		if(addressDTO != null) {
			addressModel.setCountry(addressDTO.getCountry());
			addressModel.setCity(addressDTO.getCity());
		}
		return addressModel;
	}

}
