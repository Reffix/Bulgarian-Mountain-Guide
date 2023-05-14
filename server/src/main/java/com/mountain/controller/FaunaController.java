package com.mountain.controller;

import com.mountain.model.FaunaDto;
import com.mountain.service.FaunaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
