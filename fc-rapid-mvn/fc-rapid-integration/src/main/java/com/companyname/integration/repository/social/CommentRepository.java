package com.companyname.integration.repository.social;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.companyname.persitence.entity.social.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("SELECT c FROM Comment c INNER JOIN c.author a INNER JOIN c.post p WHERE a.username =:username")
	public Page<Comment> findUserLastComments(@Param("username") String username, Pageable request);

	@Query("SELECT count(c) FROM Comment c INNER JOIN c.author a WHERE a.username =:username")
	int findUserCommentsNumber(@Param("username") String username);

}