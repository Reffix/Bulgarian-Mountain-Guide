package com.mountain.project.controller;

import com.mountain.project.model.CottageDto;
import com.mountain.project.service.CottageService;
import java.util.List;
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
@RequestMapping("/cottages")
public class CottageController {

    private final CottageService cottageService;

    public CottageController(CottageService cottageService) {
        this.cottageService = cottageService;
    }

    @GetMapping
    public List<CottageDto> getAllCottages() {
        return cottageService.getAllCottages();
    }

    @GetMapping("/{id}")
    public CottageDto getCottageById(@PathVariable("id") Long id) {
        return cottageService.getCottageById(id);
    }

    @PostMapping
    public CottageDto createCottage(@RequestBody CottageDto cottageDto) {
        return cottageService.createCottage(cottageDto);
    }

    @PutMapping("/{id}")
    public CottageDto updateCottage(@PathVariable("id") Long id, @RequestBody CottageDto cottageDto) {
        return cottageService.updateCottage(id, cottageDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCottage(@PathVariable("id") Long id) {
        boolean deleted = cottageService.deleteCottage(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
