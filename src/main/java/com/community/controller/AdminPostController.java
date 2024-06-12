package com.community.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.Service.PostService;
import com.community.entity.ApiResponse;
import com.community.entity.Post;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminPostController {
	@Autowired
	private PostService postService;

	@GetMapping("/post/getAllPost")
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	// search post by id
	@GetMapping("post/{id}")
	public Optional<Post> getPostById(@Valid @PathVariable Long id) {
		return postService.getPostById(id);
	}

	// delete post by id
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Long id) {
		this.postService.deletePost(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted Successfully", true), HttpStatus.OK);

	}

	// get post by title
	@GetMapping("/title/{title}")
	public ResponseEntity<Post> getPostByTitle(@PathVariable String title) {
		Post post = postService.findByTitle(title);
		return ResponseEntity.ok(post);
	}

	// find post by letter
	@GetMapping("/search/{letter}")
	public ResponseEntity<List<Post>> searchPostByFirstLetter(@PathVariable String letter) {
		List<Post> posts = postService.serchPostByFirstLetter(letter);
		if (posts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

}
