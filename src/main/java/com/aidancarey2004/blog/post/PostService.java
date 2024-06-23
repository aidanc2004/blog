package com.aidancarey2004.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(long id) {
        Optional<Post> post = postRepository.findById(id);
        if (!post.isPresent()) {
            throw new IllegalStateException("Post " + id + " does not exist.");
        }
        return post.get();
    }
}
