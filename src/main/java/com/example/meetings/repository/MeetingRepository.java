package com.example.meetings.repository;

import com.example.meetings.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    Optional<Meeting> findMeetingById(Long id);
    Optional<Meeting> findMeetingByOwnerID(Long id);
    List<Meeting> findAllByOwnerID(Long id);
}
