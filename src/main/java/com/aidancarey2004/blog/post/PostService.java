package com.aidancarey2004.blog.post;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public void deletePost(long id) {
        Optional<Post> post = postRepository.findById(id);
        if (!post.isPresent()) {
            throw new IllegalStateException("Post " + id + " does not exist.");
        }
        postRepository.deleteById(id);
    }

    public void updatePost(Post post) {
        List<String> errors = new ArrayList<>();

        // Check for missing fields
        if (post.getTitle().equals(""))  errors.add("Post missing title");
        if (post.getBody().equals(""))   errors.add("Post missing body");
        if (post.getAuthor().equals("")) errors.add("Post missing author");

        // Show an error if any field is missing
        if (errors.size() != 0) {
            String error = String.join(", ", errors) + "";
            throw new IllegalStateException(error);
        }

        // Update date using the old post
        Optional<Post> oldPost = postRepository.findById(post.getId());
        if (oldPost.isPresent())
            post.setDate(oldPost.get().getDate());

        // Add updated date
        post.setUpdatedDate(LocalDate.now());

        // Delete old and save new
        // TODO: Saves with a new ID number
        postRepository.deleteById(post.getId());
        postRepository.save(post);
    }

    public void newPost(Post post) {
        List<String> errors = new ArrayList<>();

        // Check for missing fields
        if (post.getTitle().equals(""))  errors.add("Post missing title");
        if (post.getBody().equals(""))   errors.add("Post missing body");
        if (post.getAuthor().equals("")) errors.add("Post missing author");

        // Show an error if any field is missing
        if (errors.size() != 0) {
            String error = String.join(", ", errors) + "";
            throw new IllegalStateException(error);
        }

        post.setDate(LocalDate.now());
        postRepository.save(post);
    }
}
