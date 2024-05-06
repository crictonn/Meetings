package com.example.meetings.service;

import com.example.meetings.controller.request.MeetingRequest;
import com.example.meetings.controller.request.MeetingsResponse;
import com.example.meetings.model.Meeting;
import com.example.meetings.repository.LocationRepository;
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
    private final LocationRepository locationRepository;

    public List<Meeting> getAll(String username) {
        return meetingRepository.findAllByOwnerID(userRepository.findUserByUsername(username).get().getId());
    }

    public MeetingsResponse getFullMeetingData(Long id, String username) {
        Boolean isOwner = false;
        Meeting meeting = meetingRepository.findMeetingById(id).orElseThrow();
        if(username.equals(userRepository.findUserById(meeting.getOwnerID()).get().getUsername()))
            isOwner = true;

        return MeetingsResponse.builder()
                .description(meeting.getDescription())
                .date(meeting.getDate())
                .name(meeting.getName())
                .location(locationRepository.findLocationById(meeting.getLocationID()).get().getName())
                .owner(userRepository.findUserById(meeting.getOwnerID()).get().getUsername())
                .isOwner(isOwner)
                .build();
    }

    public String addMeeting(MeetingRequest request, String username) {
        var meeting = Meeting.builder()
                .date(request.getDate())
                .description(request.getDescription())
                .locationID(request.getLocation())
                .name(request.getName())
                .ownerID(userRepository.findUserByUsername(username).get().getId())
                .build();

        meetingRepository.save(meeting);
        return "saved successfully";
    }
}
