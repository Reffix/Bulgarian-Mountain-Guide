package com.mountain.project.controller;

import com.mountain.project.model.HotelDto;
import com.mountain.project.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id) {
        HotelDto hotel = hotelService.getHotelById(id);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{mountain}/{page}/{size}")
    public ResponseEntity<List<HotelDto>> getAllHotelsForMountain(@PathVariable String mountain, @PathVariable int page, @PathVariable int size) {
        List<HotelDto> hotels = hotelService.getAllHotelsForMountain(mountain, page, size);
        return ResponseEntity.ok(hotels);
    }

    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        HotelDto createdHotel = hotelService.createHotel(hotelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
    }

    @PutMapping("/hotel/{id}")
    public ResponseEntity<HotelDto> updateHotel(@PathVariable Long id, @RequestBody HotelDto hotelDto) {
        HotelDto updatedHotel = hotelService.updateHotel(id, hotelDto);
        if (updatedHotel != null) {
            return ResponseEntity.ok(updatedHotel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}

