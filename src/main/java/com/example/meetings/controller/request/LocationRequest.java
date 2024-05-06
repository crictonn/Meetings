package com.example.meetings.controller.request;

import com.example.meetings.model.enums.LocationTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
    private String name;
    private String location;
    private LocationTypes type;
}
