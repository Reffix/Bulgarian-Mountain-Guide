package com.mountain.project.controller;

import com.mountain.project.model.RouteDto;
import com.mountain.project.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/{mountain}/{page}/{size}")
    public ResponseEntity<List<RouteDto>> getAllRoutesForMountain(@PathVariable String mountain, @PathVariable int page,
            @PathVariable int size) {
        List<RouteDto> allRoutesForMountain = routeService.getAllRoutesForMountain(mountain, page, size);
        return ResponseEntity.ok(allRoutesForMountain);
    }

    @GetMapping("/route/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable Long id) {
        RouteDto routeDto = routeService.getRouteById(id);
        if (routeDto != null) {
            return ResponseEntity.ok(routeDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RouteDto> createRoute(@RequestBody RouteDto routeDto) {
        RouteDto createdRouteDto = routeService.createRoute(routeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRouteDto);
    }

    @PutMapping("/route/{id}")
    public ResponseEntity<RouteDto> updateRoute(@PathVariable Long id, @RequestBody RouteDto routeDto) {
        RouteDto updatedRouteDto = routeService.updateRoute(id, routeDto);
        if (updatedRouteDto != null) {
            return ResponseEntity.ok(updatedRouteDto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/route/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}

