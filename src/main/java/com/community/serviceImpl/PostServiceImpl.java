package com.community.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.Repository.PostRepository;
import com.community.Service.PostService;
import com.community.entity.Post;
import com.community.exception.ResourceNotFoundException;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepository postRepository;

	@Override
	public Post createPost(Post post) {
		post.setPostDate(new Date());
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Optional<Post> getPostById(Long id) {
		return Optional.ofNullable(
				postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "postId", id)));
	}

	@Override
	public Post updatePost(Long id, Post updatedPost) {
		updatedPost.setId(id);
		return postRepository.save(updatedPost);
	}

	@Override
	public void deletePost(Long id) {
		Post deletePost = this.postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "postId", id));
		this.postRepository.delete(deletePost);
	}

	@Override
	public Post findByTitle(String title) {
		Optional<Post> post = postRepository.findByTitle(title);
		return post.orElseThrow(() -> new RuntimeException("Post not found with title: " + title));
	}

	@Override
	public List<Post> serchPostByFirstLetter(String letter) {
		return postRepository.findByTitleStartingWith(letter);
	}
	
	 @Override
	    public List<Post> getPostsByStatus(Boolean status) {
	        return postRepository.findByStatus(status);
	    }
		 
}
