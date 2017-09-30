package com.companyname.integration.repository.sport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.companyname.persitence.entity.sport.League;

public interface LeagueRepository extends JpaRepository<League, Integer> {

	@Query("SELECT l FROM League l WHERE l.leagueName =:league_name AND l.country =:country")
	League findByNameAndCountry(@Param("league_name") String leagueName, @Param("country") String country);

}
