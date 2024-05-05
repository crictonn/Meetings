package com.example.meetings.controller;

import com.example.meetings.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("meetings")
@RequiredArgsConstructor
@CrossOrigin
public class MeetingsController {
    private final MeetingService meetingService;

    @GetMapping()
    public ResponseEntity<?> getAllForUser(@RequestHeader String username){
        return ResponseEntity.ok(meetingService.getAll(username));
    }
}
