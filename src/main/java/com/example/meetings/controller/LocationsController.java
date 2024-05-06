package com.example.meetings.controller;

import com.example.meetings.controller.request.LocationRequest;
import com.example.meetings.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
@CrossOrigin
public class LocationsController {
    private final LocationService locationService;


    @GetMapping("/get/all")
    public ResponseEntity<?> getAllLocations(){
        return ResponseEntity.ok(locationService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveLocation(@RequestBody LocationRequest request){
        return ResponseEntity.ok(locationService.save(request));
    }
}
