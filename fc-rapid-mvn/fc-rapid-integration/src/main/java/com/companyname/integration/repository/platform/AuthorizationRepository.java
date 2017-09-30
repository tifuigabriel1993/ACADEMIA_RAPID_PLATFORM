package com.companyname.integration.repository.platform;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyname.persitence.entity.platform.Authorization;

public interface AuthorizationRepository extends
		JpaRepository<Authorization, Long> {

}
