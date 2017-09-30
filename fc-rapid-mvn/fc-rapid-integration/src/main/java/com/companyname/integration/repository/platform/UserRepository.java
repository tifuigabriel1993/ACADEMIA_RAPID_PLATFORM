package com.companyname.integration.repository.platform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.companyname.persitence.entity.platform.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username =:username")
	public User findUserByUsername(@Param("username") String username);

	@Query("SELECT u FROM User u WHERE u.email =:email")
	public User findUserByEmail(@Param("email") String email);

	@Query("SELECT u FROM User u WHERE u.facebookId =:facebookId")
	public User findUserByFacebookId(@Param("facebookId") String facebookId);

	@Query("SELECT u.password FROM User u WHERE u.email =:email")
	public String getPasswordByEmail(@Param("email") String email);

	@Query("SELECT u.password FROM User u WHERE u.username =:username")
	public String getPasswordByUsername(@Param("username") String username);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.userProfile p WHERE u.username =:username")
	public User findUserWithProfile(@Param("username") String username);

}
