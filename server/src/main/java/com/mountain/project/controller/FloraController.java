package com.mountain.project.controller;

import com.mountain.project.model.FloraDto;
import com.mountain.project.service.FloraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floras")
public class FloraController {
    private final FloraService floraService;

    @Autowired
    public FloraController(FloraService floraService) {
        this.floraService = floraService;
    }

    @GetMapping("/flora/{id}")
    public ResponseEntity<FloraDto> getFloraById(@PathVariable Long id) {
        FloraDto floraDto = floraService.getFloraById(id);
        if (floraDto != null) {
            return ResponseEntity.ok(floraDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{mountain}/{page}/{size}")
    public ResponseEntity<List<FloraDto>> getAllFlorasForMountain(String mountain, @PathVariable int page,
            @PathVariable int size) {
        List<FloraDto> floraDtos = floraService.getAllFlorasForMountain(mountain, page, size);
        return ResponseEntity.ok(floraDtos);
    }

    @PostMapping
    public ResponseEntity<FloraDto> createFlora(@RequestBody FloraDto floraDto) {
        FloraDto createdFlora = floraService.createFlora(floraDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlora);
    }

    @PutMapping("/flora/{id}")
    public ResponseEntity<FloraDto> updateFlora(@PathVariable Long id, @RequestBody FloraDto floraDto) {
        FloraDto updatedFlora = floraService.updateFlora(id, floraDto);
        if (updatedFlora != null) {
            return ResponseEntity.ok(updatedFlora);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/flora/{id}")
    public ResponseEntity<Void> deleteFlora(@PathVariable Long id) {
        floraService.deleteFlora(id);
        return ResponseEntity.noContent().build();
    }
}








