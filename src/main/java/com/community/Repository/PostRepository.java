package com.community.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.community.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
