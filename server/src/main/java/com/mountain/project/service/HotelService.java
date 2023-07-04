package com.mountain.project.service;

import com.mountain.project.entity.HotelEntity;
import com.mountain.project.entity.UserEntity;
import com.mountain.project.enums.Mountain;
import com.mountain.project.mapper.HotelMapper;
import com.mountain.project.model.HotelDto;
import com.mountain.project.repository.HotelRepository;
import com.mountain.project.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;
    private final HotelMapper hotelMapper;

    public HotelService(HotelRepository hotelRepository, UserRepository userRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
        this.hotelMapper = hotelMapper;
    }

    public HotelDto getHotelById(Long id) {
        Optional<HotelEntity> hotelEntity = hotelRepository.findById(id);
        if (hotelEntity.isEmpty()) {
            throw new EntityNotFoundException("Hotel not found with ID: " + id);
        }
        return hotelMapper.convertHotelEntityToHotelDto(hotelEntity.get());
    }

    public List<HotelDto> getAllHotelsForMountain(String mountain, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("premium").descending());
        List<HotelEntity> hotelEntities = hotelRepository.findAllByMountain(Mountain.valueOf(mountain.toUpperCase()), pageable);
        return hotelMapper.convertListHotelEntityToListHotelDto(hotelEntities);
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

    @Transactional
    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new EntityNotFoundException("Hotel not found with ID: " + id);
        }

        HotelEntity hotelEntity = hotelRepository.getById(id);
        List<UserEntity> userEntities = userRepository.findAllByFavouriteHotelsContains(hotelEntity);

        for(UserEntity user : userEntities) {
            UserEntity userEntity = userRepository.getById(user.getId());
            userEntity.getFavouriteHotels().remove(hotelEntity);
            userRepository.save(userEntity);
        }

        hotelRepository.delete(hotelEntity);
    }
}

