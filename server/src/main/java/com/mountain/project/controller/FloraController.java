package com.mountain.project.controller;

import com.mountain.project.model.FloraDto;
import com.mountain.project.service.FloraService;
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
        return ResponseEntity.ok(floraDto);
    }

    @GetMapping("/{mountain}")
    public ResponseEntity<List<FloraDto>> getAllFlorasForMountain(String mountain) {
        List<FloraDto> floraDtos = floraService.getAllFlorasForMountain(mountain);
        return ResponseEntity.ok(floraDtos);
    }

    @PostMapping
    public ResponseEntity<FloraDto> createFlora(@RequestBody FloraDto floraDto) {
        FloraDto createdFlora = floraService.createFlora(floraDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FloraDto> updateFlora(@PathVariable Long id, @RequestBody FloraDto floraDto) {
        FloraDto updatedFlora = floraService.updateFlora(id, floraDto);
        return ResponseEntity.ok(updatedFlora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlora(@PathVariable Long id) {
        floraService.deleteFlora(id);
        return ResponseEntity.noContent().build();
    }
}








