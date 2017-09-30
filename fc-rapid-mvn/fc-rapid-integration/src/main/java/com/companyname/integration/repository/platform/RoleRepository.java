package com.companyname.integration.repository.platform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.companyname.persitence.entity.platform.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("SELECT r FROM Role r WHERE r.name =:roleName")
	Role findByName(@Param("roleName") String roleName);
	
}