package org.example.controller;

import org.example.model.Post;
import org.example.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<User> users  = new ArrayList<User>();

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(defaultValue = "10") Integer limit) {
        var result = users.stream().limit(limit).toList();
        return ResponseEntity.ok()
                .body(result);
    } // 200

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    } // 201

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        users.removeIf(user -> user.getId().equals(id));
        return ResponseEntity.noContent().build();
    } // 204
}
