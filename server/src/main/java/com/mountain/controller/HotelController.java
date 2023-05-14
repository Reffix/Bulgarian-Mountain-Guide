package com.mountain.controller;

import com.mountain.model.HotelDto;
import com.mountain.service.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/{id}")
    public HotelDto getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping
    public List<HotelDto> getAllHotels() {
        return hotelService.getAllHotels();
    }
}
