package com.example.meetings.service;

import com.example.meetings.controller.request.LocationRequest;
import com.example.meetings.model.Location;
import com.example.meetings.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    public List<Location> getAll(){
        return locationRepository.findAll();
    }

    public String save(LocationRequest request){
        var location = Location.builder()
                .location(request.getLocation())
                .locationType(request.getType())
                .name(request.getName())
                .build();
        locationRepository.save(location);
        return "location added";
    }
}
