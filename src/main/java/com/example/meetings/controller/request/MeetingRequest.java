package com.example.meetings.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingRequest {
    private Date date;
    private String name;
    private String description;
    private Long location;
    private Long owner;
}
