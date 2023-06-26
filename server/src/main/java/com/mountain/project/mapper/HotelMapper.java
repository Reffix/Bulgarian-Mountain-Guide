package com.mountain.project.mapper;

import com.mountain.project.entity.HotelEntity;
import com.mountain.project.model.HotelDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelDto convertHotelEntityToHotelDto(HotelEntity hotelEntity) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotelEntity.getId());
        hotelDto.setName(hotelEntity.getName());
        hotelDto.setDescription(hotelEntity.getDescription());
        hotelDto.setStars(hotelEntity.getStars());
        hotelDto.setLinkToSite(hotelEntity.getLinkToSite());
        hotelDto.setPicture(hotelEntity.getPicture());
        hotelDto.setPremium(hotelEntity.isPremium());
        return hotelDto;
    }

    public List<HotelDto> convertListHotelEntityToListHotelDto(List<HotelEntity> hotels) {
        List<HotelDto> hotelDtos = new ArrayList<>();
        for (HotelEntity hotelEntity : hotels) {
            hotelDtos.add(convertHotelEntityToHotelDto(hotelEntity));
        }
        return hotelDtos;
    }

    public HotelEntity convertHotelDtoToHotelEntity(HotelDto hotelDto) {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(hotelDto.getId());
        hotelEntity.setName(hotelDto.getName());
        hotelEntity.setDescription(hotelDto.getDescription());
        hotelEntity.setStars(hotelDto.getStars());
        hotelEntity.setLinkToSite(hotelDto.getLinkToSite());
        hotelEntity.setPicture(hotelDto.getPicture());
        hotelEntity.setPremium(hotelDto.isPremium());
        return hotelEntity;
    }

    public List<HotelEntity> convertListHotelDtoToListHotelEntity(List<HotelDto> hotelDtos) {
        List<HotelEntity> hotelEntities = new ArrayList<>();
        for (HotelDto hotelDto : hotelDtos) {
            hotelEntities.add(convertHotelDtoToHotelEntity(hotelDto));
        }
        return hotelEntities;
    }
}
