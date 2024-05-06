package com.example.meetings.controller;

import com.example.meetings.model.User;
import com.example.meetings.service.PersonService;
import com.example.meetings.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestHeader String username){
        return ResponseEntity.ok(userService.getAllData(username));
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllUsers(){
        List<User> test = userService.getAll();
        return ResponseEntity.ok(test);
    }
}
