package com.mountain.project.controller;

import com.mountain.project.model.LandmarkDto;
import com.mountain.project.service.LandmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landmarks")
public class LandmarkController {

    private final LandmarkService landmarkService;

    public LandmarkController(LandmarkService landmarkService) {
        this.landmarkService = landmarkService;
    }

    @GetMapping("/landmark/{id}")
    public ResponseEntity<LandmarkDto> getLandmarkById(@PathVariable Long id) {
        LandmarkDto landmarkDto = landmarkService.getLandmarkById(id);
        if (landmarkDto != null) {
            return ResponseEntity.ok(landmarkDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{mountain}")
    public ResponseEntity<List<LandmarkDto>> getAllLandmarksForMountain(@PathVariable String mountain) {
        List<LandmarkDto> landmarkDtos = landmarkService.getAllLandmarksForMountain(mountain);
        return ResponseEntity.ok(landmarkDtos);
    }

    @PostMapping
    public ResponseEntity<LandmarkDto> createLandmark(@RequestBody LandmarkDto landmarkDto) {
        LandmarkDto createdLandmark = landmarkService.createLandmark(landmarkDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLandmark);
    }

    @PutMapping("/landmark/{id}")
    public ResponseEntity<LandmarkDto> updateLandmark(@PathVariable Long id, @RequestBody LandmarkDto landmarkDto) {
        LandmarkDto updatedLandmark = landmarkService.updateLandmark(id, landmarkDto);
        if (updatedLandmark != null) {
            return ResponseEntity.ok(updatedLandmark);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/landmark/{id}")
    public ResponseEntity<Void> deleteLandmark(@PathVariable Long id) {
        landmarkService.deleteLandmark(id);
        return ResponseEntity.noContent().build();
    }
}

