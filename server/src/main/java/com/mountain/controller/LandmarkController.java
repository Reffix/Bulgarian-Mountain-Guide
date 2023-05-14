package com.mountain.controller;

import com.mountain.model.LandmarkDto;
import com.mountain.service.LandmarkService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/landmarks")
public class LandmarkController {

    private final LandmarkService landmarkService;

    public LandmarkController(LandmarkService landmarkService) {
        this.landmarkService = landmarkService;
    }

    @GetMapping("/{id}")
    public LandmarkDto getLandmarkById(@PathVariable Long id) {
        return landmarkService.getLandmarkById(id);
    }

    @GetMapping("")
    public List<LandmarkDto> getAllLandmarks() {
        return landmarkService.getAllLandmarks();
    }
}
