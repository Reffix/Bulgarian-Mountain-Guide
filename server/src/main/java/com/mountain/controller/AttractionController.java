package com.mountain.controller;

import com.mountain.enums.Mountain;
import com.mountain.model.AttractionDto;
import com.mountain.service.AttractionService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttractionDto> getAttractionById(@PathVariable Long id) {
        AttractionDto attraction = attractionService.getAttractionById(id);
        return ResponseEntity.ok(attraction);
    }

    @GetMapping("/{mountain}")
    public ResponseEntity<List<AttractionDto>> getAllAttractions(@PathVariable Mountain mountain) {
        List<AttractionDto> attractions = attractionService.getAllAttractionsForMountain(mountain);
        return ResponseEntity.ok(attractions);
    }
}
