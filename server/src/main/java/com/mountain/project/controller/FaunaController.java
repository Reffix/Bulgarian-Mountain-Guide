package com.mountain.project.controller;

import com.mountain.project.model.FaunaDto;
import com.mountain.project.service.FaunaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fauna")
public class FaunaController {

    private final FaunaService faunaService;

    public FaunaController(FaunaService faunaService) {
        this.faunaService = faunaService;
    }

    @GetMapping("/fauna/{id}")
    public ResponseEntity<FaunaDto> getFaunaById(@PathVariable Long id) {
        FaunaDto fauna = faunaService.getFaunaById(id);
        if (fauna != null) {
            return ResponseEntity.ok(fauna);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{mountain}")
    public ResponseEntity<List<FaunaDto>> getAllFaunasForMountain(@PathVariable String mountain) {
        List<FaunaDto> faunas = faunaService.getAllFaunasForMountain(mountain);
        return ResponseEntity.ok(faunas);
    }

    @PostMapping
    public ResponseEntity<FaunaDto> createFauna(@RequestBody FaunaDto faunaDto) {
        FaunaDto createdFauna = faunaService.createFauna(faunaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFauna);
    }

    @PutMapping("/fauna/{id}")
    public ResponseEntity<FaunaDto> updateFauna(@PathVariable Long id, @RequestBody FaunaDto faunaDto) {
        FaunaDto updatedFauna = faunaService.updateFauna(id, faunaDto);
        if (updatedFauna != null) {
            return ResponseEntity.ok(updatedFauna);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/fauna/{id}")
    public ResponseEntity<Void> deleteFauna(@PathVariable Long id) {
        faunaService.deleteFauna(id);
        return ResponseEntity.noContent().build();
    }
}

