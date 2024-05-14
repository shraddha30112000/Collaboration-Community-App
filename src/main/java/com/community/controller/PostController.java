package com.community.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.Service.PostService;
import com.community.entity.Post;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private PostService postService;

	// add new Post
	@PostMapping("/")
	public Post createPost(@Valid@RequestBody Post post) {
		return postService.createPost(post);
	}

	// get all post
	@GetMapping("/")
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	// search post by id
	@GetMapping("/{id}")
	public Optional<Post> getPostById(@Valid@PathVariable Long id) {
		return postService.getPostById(id);
	}

	// update post by id
	@PutMapping("/{id}")
	public Post updatePost(@Valid@PathVariable Long id, @RequestBody Post updatedPost) {
		return postService.updatePost(id, updatedPost);
	}

	// delete post by id
	@DeleteMapping("/{id}")
	public Long deletePost(@Valid@PathVariable Long id) {
		postService.deletePost(id);
		return id;
	}
}
