package com.example.dashboard_backend.controller;

import com.example.dashboard_backend.entity.User;
import com.example.dashboard_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> savUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("User saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save user!");
        }
    }

    @GetMapping("/getAll")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateUser(@RequestParam Long user_id, @RequestBody Map<String, Object> fields) {
        try {
            User user = userService.updateUser(user_id, fields);
            return ResponseEntity.ok("User updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update User!");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam Long user_id) {
        try {
            userService.deleteUserById(user_id);
            return ResponseEntity.ok("User deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to delete user!");
        }
    }
}
