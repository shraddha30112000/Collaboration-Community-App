package com.community.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.community.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	//Post findPostByTitle(String title);
	Optional<Post> findByTitle(String title);
	List<Post> findByTitleStartingWith(String letter);
	List<Post> findByStatus(Boolean status);
}
 