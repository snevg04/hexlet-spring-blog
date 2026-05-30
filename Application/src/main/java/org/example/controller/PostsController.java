package org.example.controller;

import org.example.model.Post;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostsController {

    private List<Post> posts = new ArrayList<Post>();

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(defaultValue = "10") Integer limit) {
        var result = posts.stream().limit(limit).toList();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(result);
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> show(@PathVariable String id) {
        var post = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(post);
    }

    @PutMapping("/posts/{id}")
    public Post update(@PathVariable String id, @RequestBody Post data) {
        var maybePost = posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
        if (maybePost.isPresent()) {
            var post = maybePost.get();
            post.setTitle(data.getTitle());
            post.setContent(data.getContent());
        }
        return data;
    }

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(post -> post.getId().equals(id));
    }

}
