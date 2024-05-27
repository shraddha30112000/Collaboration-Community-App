package com.community.Service;

import java.util.List;
import java.util.Optional;
import com.community.entity.Post;

public interface PostService {

	Post createPost(Post post);
	List<Post> getAllPosts();
	Optional<Post> getPostById(Long id);
	Post updatePost(Long id, Post updatedPost);
	void deletePost(Long id);
	Post findByTitle(String title);
	List<Post> serchPostByFirstLetter(String letter);
	List<Post> getPostsByStatus(Boolean status);
}
