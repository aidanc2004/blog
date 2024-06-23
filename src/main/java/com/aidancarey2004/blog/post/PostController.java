package com.aidancarey2004.blog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping
    public void newPost(@RequestBody Post post) {
        // TODO: Make a new post
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable long id) {
        // TODO: Update a post
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id) {
        // TODO: Delete a post
    }
}
