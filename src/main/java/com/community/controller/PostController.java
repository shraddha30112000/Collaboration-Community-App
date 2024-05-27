package com.community.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.Service.PostService;
import com.community.entity.ApiResponse;
import com.community.entity.Post;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private PostService postService;

	// add new Post
	@PostMapping("/add")
	public Post createPost(@Valid @RequestBody Post post) {
		return postService.createPost(post);
	}

	// get all post
	@GetMapping("/get")
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}

	// search post by id
	@GetMapping("/{id}")
	public Optional<Post> getPostById(@Valid @PathVariable Long id) {
		return postService.getPostById(id);
	}

	// update post by id
	@PutMapping("/{id}")
	/*
	 * public Post updatePost(@Valid @PathVariable Long id, @RequestBody Post
	 * updatedPost) { return postService.updatePost(id, updatedPost); }
	 */
	public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody Post post) {
		Post updatePost = this.postService.updatePost(id, post);
		return ResponseEntity.ok(updatePost);
	}

	// delete post by id
	@DeleteMapping("/{id}")
	/*
	 * public Long deletePost(@Valid@PathVariable Long id) {
	 * postService.deletePost(id); return id; }
	 */
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

	@GetMapping("/status/{status}")
	public ResponseEntity<List<Post>> getPostsByStatus(@PathVariable Boolean status) {
		List<Post> posts = postService.getPostsByStatus(status);
		if (!posts.isEmpty()) {
			return ResponseEntity.ok(posts);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
