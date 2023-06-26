package com.mountain.project.controller;

import com.mountain.project.model.FaunaDto;
import com.mountain.project.service.FaunaService;
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
@RequestMapping("/faunas")
public class FaunaController {

    private final FaunaService faunaService;

    public FaunaController(FaunaService faunaService) {
        this.faunaService = faunaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaunaDto> getFaunaById(@PathVariable Long id) {
        FaunaDto fauna = faunaService.getFaunaById(id);
        return ResponseEntity.ok(fauna);
    }

    @GetMapping
    public ResponseEntity<List<FaunaDto>> getAllFaunas() {
        List<FaunaDto> faunas = faunaService.getAllFaunas();
        return ResponseEntity.ok(faunas);
    }

    @PostMapping
    public ResponseEntity<FaunaDto> createFauna(@RequestBody FaunaDto faunaDto) {
        FaunaDto createdFauna = faunaService.createFauna(faunaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFauna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaunaDto> updateFauna(@PathVariable Long id, @RequestBody FaunaDto faunaDto) {
        FaunaDto updatedFauna = faunaService.updateFauna(id, faunaDto);
        return ResponseEntity.ok(updatedFauna);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFauna(@PathVariable Long id) {
        faunaService.deleteFauna(id);
        return ResponseEntity.noContent().build();
    }
}
