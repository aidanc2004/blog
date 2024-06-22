package com.aidancarey2004.blog.post;

import org.springframework.web.bind.annotation.*;

@RestController
// TODO: @RequestMapping("/api/v1/post")
public class PostController {
    @GetMapping("/posts")
    public String posts() {
        return "<h1>Posts</h1>";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable Long id) {
        // TODO: Get a post
        return "<h1>Post " + id + "</h1>";
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
