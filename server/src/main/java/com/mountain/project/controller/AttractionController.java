package com.mountain.project.controller;

import com.mountain.project.model.AttractionDto;
import com.mountain.project.service.AttractionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("/{mountain}/{page}/{size}")
    public ResponseEntity<List<AttractionDto>> getAllAttractionsForMountain(@PathVariable String mountain, @PathVariable int page, @PathVariable int size) {
        List<AttractionDto> attractions = attractionService.getAllAttractionsForMountain(mountain, page, size);
        return ResponseEntity.ok(attractions);
    }

    @GetMapping("/attraction/{id}")
    public ResponseEntity<AttractionDto> getAttractionById(@PathVariable Long id) {
        AttractionDto attractionDto = attractionService.getAttractionById(id);
        if (attractionDto != null) {
            return ResponseEntity.ok(attractionDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AttractionDto> createAttraction(@RequestBody AttractionDto attractionDto) {
        AttractionDto createdAttraction = attractionService.createAttraction(attractionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttraction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttractionDto> updateAttraction(@PathVariable Long id, @RequestBody AttractionDto attractionDto) {
        AttractionDto updatedAttraction = attractionService.updateAttraction(id, attractionDto);
        if (updatedAttraction != null) {
            return ResponseEntity.ok(updatedAttraction);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable Long id) {
        attractionService.deleteAttraction(id);
        return ResponseEntity.noContent().build();
    }
}

