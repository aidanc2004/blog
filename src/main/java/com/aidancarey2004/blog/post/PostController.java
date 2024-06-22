package com.aidancarey2004.blog.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// TODO: @RequestMapping("/api/v1/post")
public class PostController {
    @GetMapping("/posts")
    public String posts() {
        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable Long id, Model model) {
        // TODO: Get a post
        model.addAttribute("id", id);
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
