package codemasters.codematersspringcrud.controllers;

import codemasters.codematersspringcrud.entity.Post;
import codemasters.codematersspringcrud.exception.PostNotFoundException;
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

    @PutMapping("/posts/{id}")
    Long updatePost(@RequestBody Post newpost, @PathVariable Long id) {

        return postService.findById(id)
                .map(post -> {
                    post.setTitle(newpost.getTitle());
                    post.setBody(newpost.getBody());
                    post.setPicture(newpost.getPicture());
                    return postService.save(post);
                }).orElseThrow(() -> new PostNotFoundException(id));

    }

    @DeleteMapping("/posts/{id}")
    String deletePost(@PathVariable Long id) {

        if (!postService.existsById(id)) {
            throw new PostNotFoundException(id);
        }
        postService.deleteById(id);
        return "Post with id " + id + " has been deleted";

    }

}