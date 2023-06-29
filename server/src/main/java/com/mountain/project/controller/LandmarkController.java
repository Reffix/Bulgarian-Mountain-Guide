package com.mountain.project.controller;

import com.mountain.project.model.LandmarkDto;
import com.mountain.project.service.LandmarkService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(landmarkDto);
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

    @PutMapping("/{id}")
    public ResponseEntity<LandmarkDto> updateLandmark(@PathVariable Long id, @RequestBody LandmarkDto landmarkDto) {
        LandmarkDto updatedLandmark = landmarkService.updateLandmark(id, landmarkDto);
        return ResponseEntity.ok(updatedLandmark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLandmark(@PathVariable Long id) {
        landmarkService.deleteLandmark(id);
        return ResponseEntity.noContent().build();
    }
}

