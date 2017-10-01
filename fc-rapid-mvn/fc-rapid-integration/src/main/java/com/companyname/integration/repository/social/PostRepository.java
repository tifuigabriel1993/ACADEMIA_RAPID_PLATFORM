package com.companyname.integration.repository.social;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.companyname.persitence.entity.social.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PagingAndSortingRepository<Post, Long> {

	@Query("SELECT p FROM Post p ORDER BY p.postDate DESC")
	List<Post> findAllSortedByCreationDate();

	@Query("SELECT p FROM Post p where p.type = :type")
	Page<Post> findPostsByType(@Param(value = "type") String type, Pageable request);

	@Query("SELECT p FROM Post p INNER JOIN p.author a WHERE a.username =:username")
	Page<Post> findPostsByUser(@Param("username") String username, Pageable request);
	
	@Query("SELECT p FROM Post p where p.type = :type and p.postId in (select c from Category c where c.name in :categories)")
	Page<Post> findPostsByTypeAndCategory(@Param(value = "type") String type,
			@Param(value = "categories") Set<String> categories,
			Pageable request);

}