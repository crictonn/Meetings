package com.example.meetings.controller;

import com.example.meetings.controller.request.MeetingRequest;
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

    @GetMapping("meeting/{id}")
    public ResponseEntity<?> getMeetingWithId(@PathVariable Long id, @RequestHeader String username){
        return ResponseEntity.ok(meetingService.getFullMeetingData(id, username));
    }

    @PostMapping("/new")
    public ResponseEntity<?> addNewMeeting(@RequestBody MeetingRequest request, @RequestHeader String username){
        return ResponseEntity.ok(meetingService.addMeeting(request, username));
    }
}
