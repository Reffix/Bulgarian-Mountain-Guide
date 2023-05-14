package com.mountain.controller;

import com.mountain.model.FloraDto;
import com.mountain.service.FloraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<FloraDto> getFloraById(@PathVariable Long id) {
        FloraDto floraDto = floraService.getFloraById(id);
        return ResponseEntity.ok(floraDto);
    }

    @GetMapping
    public ResponseEntity<List<FloraDto>> getAllFloras() {
        List<FloraDto> floraDtos = floraService.getAllFloras();
        return ResponseEntity.ok(floraDtos);
    }
}







