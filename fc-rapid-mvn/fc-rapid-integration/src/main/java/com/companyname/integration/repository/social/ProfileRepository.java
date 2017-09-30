package com.companyname.integration.repository.social;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyname.persitence.entity.social.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
