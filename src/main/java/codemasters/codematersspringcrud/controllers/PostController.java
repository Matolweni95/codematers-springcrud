package codemasters.codematersspringcrud.controllers;

import codemasters.codematersspringcrud.entity.Post;
import codemasters.codematersspringcrud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/posts")

public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    Long newPost(@RequestBody Post newPost) {
        System.out.println("post");
        return postService.save(newPost);
    }

    @GetMapping("/posts")
    List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    Optional<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

}