package com.example.meetings.service;

import com.example.meetings.controller.request.MeetingsRequest;
import com.example.meetings.model.Meeting;
import com.example.meetings.model.User;
import com.example.meetings.repository.MeetingRepository;
import com.example.meetings.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final UserRepository userRepository;

    public List<Meeting> getAll(String username) {
        return meetingRepository.findAllByOwnerID(userRepository.findUserByUsername(username).get().getId());
//        Meeting meeting = meetingRepository.findMeetingByOwnerID(userRepository.findUserByUsername(username).get().getId()).orElseThrow();
//        User owner = userRepository.findUserByUsername(username).orElseThrow();
//        return MeetingsRequest.builder()
//                .description(meeting.getDescription())
//                .date(meeting.getDate())
//                .name(meeting.getName())
//                .location(meeting.getLocationID())
//                .owner(owner.getUsername())
//                .build();
    }
}
