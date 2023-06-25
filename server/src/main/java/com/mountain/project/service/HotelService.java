package com.mountain.project.service;

import com.mountain.project.entity.HotelEntity;
import com.mountain.project.mapper.HotelMapper;
import com.mountain.project.model.HotelDto;
import com.mountain.project.repository.HotelRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
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
            throw new EntityNotFoundException("Hotel not found with ID: " + id);
        }
        return hotelMapper.convertHotelEntityToHotelDto(hotelEntity.get());
    }

    public List<HotelDto> getAllHotels() {
        List<HotelEntity> hotels = hotelRepository.findAll();
        return hotelMapper.convertListHotelEntityToListHotelDto(hotels);
    }

    public HotelDto createHotel(HotelDto hotelDto) {
        HotelEntity hotelEntity = hotelMapper.convertHotelDtoToHotelEntity(hotelDto);
        HotelEntity savedHotelEntity = hotelRepository.save(hotelEntity);
        return hotelMapper.convertHotelEntityToHotelDto(savedHotelEntity);
    }

    public HotelDto updateHotel(Long id, HotelDto hotelDto) {
        Optional<HotelEntity> hotelEntityOptional = hotelRepository.findById(id);
        if (hotelEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Hotel not found with ID: " + id);
        }
        HotelEntity hotelEntity = hotelEntityOptional.get();
        hotelEntity.setName(hotelDto.getName());
        hotelEntity.setDescription(hotelDto.getDescription());
        hotelEntity.setStars(hotelDto.getStars());
        hotelEntity.setLinkToSite(hotelDto.getLinkToSite());
        hotelEntity.setPicture(hotelDto.getPicture());
        hotelEntity.setPremium(hotelDto.isPremium());

        HotelEntity updatedHotelEntity = hotelRepository.save(hotelEntity);
        return hotelMapper.convertHotelEntityToHotelDto(updatedHotelEntity);
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new EntityNotFoundException("Hotel not found with ID: " + id);
        }
        hotelRepository.deleteById(id);
    }
}

