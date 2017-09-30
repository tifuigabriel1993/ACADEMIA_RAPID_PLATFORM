package com.companyname.integration.repository.social;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserConnectionRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserConnectionRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String getProviderId(String providerId, String email) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("providerId", providerId);
		parameters.addValue("email", email);

		return new NamedParameterJdbcTemplate(jdbcTemplate).query(
				"select provideruserid from UserConnection where providerId = :providerId and userid = :email", parameters,
				new ResultSetExtractor<String>() {
					@Override
					public String extractData(ResultSet rs) throws SQLException, DataAccessException {
						while (rs.next()) {
							return rs.getString("provideruserid");
						}
						return null;
					}
				});
	}

}
