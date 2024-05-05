package com.example.meetings.controller;

import com.example.meetings.service.PersonService;
import com.example.meetings.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final PersonService personService;

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestHeader String username){
        return ResponseEntity.ok(userService.getAllData(username));
    }
}
