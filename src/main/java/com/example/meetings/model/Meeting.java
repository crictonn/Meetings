package com.example.meetings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="meetings")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "owner_id")
    private Long ownerID;

    @Column(name = "location_id")
    private Long locationID;

    @ManyToMany
    private List<User> participants;
}
