package com.mountain.service;

import com.mountain.entity.HotelEntity;
import com.mountain.mapper.HotelMapper;
import com.mountain.model.HotelDto;
import com.mountain.repository.HotelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    public HotelDto getHotelById(Long id) {
        Optional<HotelEntity> hotelEntity = hotelRepository.findById(id);
        if (hotelEntity.isEmpty()) {
            throw new RuntimeException("Hotel with id " + id + " not found");
        }
        return hotelMapper.convertHotelEntityToHotelDto(hotelEntity.get());
    }

    public List<HotelDto> getAllHotels() {
        List<HotelEntity> hotels = hotelRepository.findAll();
        return hotelMapper.convertListHotelEntityToListHotelDto(hotels);
    }
}
