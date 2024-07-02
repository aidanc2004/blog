package com.aidancarey2004.blog.post;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/posts/new")
    public String newPostPage(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "newPost";
    }

    @GetMapping("/posts/{id}/update")
    public String updatePostPage(@PathVariable long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "updatePost";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/posts/new")
    public RedirectView newPost(@ModelAttribute Post post) {
        postService.newPost(post);
        return new RedirectView("/posts");
    }

    @PostMapping("/posts/{id}/update")
    public RedirectView updatePost(@ModelAttribute Post post, @PathVariable long id) {
        postService.updatePost(post);
        return new RedirectView("/posts");
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id) {
       postService.deletePost(id);
    }
}
