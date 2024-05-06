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
public class MeetingsResponse {
    private Date date;
    private String name;
    private String description;
    private String location;
    private String owner;
    private Boolean isOwner;
}
