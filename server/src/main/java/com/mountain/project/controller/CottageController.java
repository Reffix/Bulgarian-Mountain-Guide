package com.mountain.project.controller;

import com.mountain.project.model.CottageDto;
import com.mountain.project.service.CottageService;
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
@RequestMapping("/cottages")
public class CottageController {

    private final CottageService cottageService;

    public CottageController(CottageService cottageService) {
        this.cottageService = cottageService;
    }

    @GetMapping("/{mountain}/{page}/{size}")
    public ResponseEntity<List<CottageDto>> getAllCottagesForMountain(@PathVariable String mountain, @PathVariable int page, @PathVariable int size) {
        List<CottageDto> allCottagesForMountain = cottageService.getAllCottagesForMountain(mountain, page, size);
        return ResponseEntity.ok(allCottagesForMountain);
    }

    @GetMapping("/cottage/{id}")
    public ResponseEntity<CottageDto> getCottageById(@PathVariable("id") Long id) {
        CottageDto cottageById = cottageService.getCottageById(id);
        if (cottageById != null) {
            return ResponseEntity.ok(cottageById);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CottageDto> createCottage(@RequestBody CottageDto cottageDto) {
        CottageDto cottage = cottageService.createCottage(cottageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cottage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CottageDto> updateCottage(@PathVariable("id") Long id, @RequestBody CottageDto cottageDto) {
        CottageDto cottage = cottageService.updateCottage(id, cottageDto);
        if (cottage != null) {
            return ResponseEntity.ok(cottage);
        }
        return ResponseEntity.notFound().build();
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
