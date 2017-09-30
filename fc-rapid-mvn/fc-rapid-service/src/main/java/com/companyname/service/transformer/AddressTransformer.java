package com.companyname.service.transformer;

import org.springframework.stereotype.Component;

import com.companyname.persitence.entity.social.Address;
import com.companyname.service.dto.platform.AddressDTO;

@Component
public class AddressTransformer {

	public AddressDTO toDto(Address address) {
		AddressDTO addressDto = new AddressDTO();
		if(address != null) {
			addressDto.setCountry(address.getCountry());
			addressDto.setCity(address.getCity());
		}
		return addressDto;
	}

	public Address toEntity(AddressDTO addressDto) {
		Address address = new Address();
		address.setCountry(addressDto.getCountry());
		address.setCity(addressDto.getCity());
		return address;
	}

}
