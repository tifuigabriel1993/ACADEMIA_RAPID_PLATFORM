package com.companyname.integration.repository.social;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.companyname.persitence.entity.social.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	@Query("SELECT a FROM Address a WHERE a.country =:country AND a.city =:city")
	Address findByCityAndCountry(@Param("country") String country, @Param("city") String city);

}