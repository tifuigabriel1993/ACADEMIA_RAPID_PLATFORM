package com.companyname.integration.repository.sport;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyname.persitence.entity.sport.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
