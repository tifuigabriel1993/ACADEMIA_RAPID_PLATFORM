package com.companyname.integration.repository.sport;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyname.persitence.entity.sport.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
