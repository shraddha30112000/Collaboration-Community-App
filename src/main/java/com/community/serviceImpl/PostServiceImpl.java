package com.community.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.Repository.PostRepository;
import com.community.Service.PostService;
import com.community.entity.Post;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Post createPost(Post post) {
		post.setDate(new Date());
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Optional<Post> getPostById(Long id) {
		return postRepository.findById(id);
	}

	@Override
	public Post updatePost(Long id, Post updatedPost) {
		updatedPost.setId(id);
		return postRepository.save(updatedPost);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
	
}
