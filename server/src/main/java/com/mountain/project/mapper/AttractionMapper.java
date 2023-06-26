package com.mountain.project.mapper;

import com.mountain.project.entity.AttractionEntity;
import com.mountain.project.model.AttractionDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AttractionMapper {

    public AttractionDto convertAttractionEntityToDto(AttractionEntity attractionEntity) {
        AttractionDto attractionDto = new AttractionDto();
        attractionDto.setId(attractionEntity.getId());
        attractionDto.setName(attractionEntity.getName());
        attractionDto.setDescription(attractionEntity.getDescription());
        attractionDto.setLocation(attractionEntity.getLocation());
        attractionDto.setPremium(attractionEntity.isPremium());
        attractionDto.setPicture(attractionEntity.getPicture());
        attractionDto.setMountain(attractionEntity.getMountain());
        return attractionDto;
    }

    public List<AttractionDto> convertListEntityToDto(List<AttractionEntity> attractionEntities) {
        List<AttractionDto> attractionDtos = new ArrayList<>();
        for (AttractionEntity attractionEntity : attractionEntities) {
            attractionDtos.add(convertAttractionEntityToDto(attractionEntity));
        }
        return attractionDtos;
    }

    public AttractionEntity convertDtoToAttractionEntity(AttractionDto attractionDto) {
        AttractionEntity attractionEntity = new AttractionEntity();
        attractionEntity.setId(attractionDto.getId());
        attractionEntity.setName(attractionDto.getName());
        attractionEntity.setDescription(attractionDto.getDescription());
        attractionEntity.setLocation(attractionDto.getLocation());
        attractionEntity.setPremium(attractionDto.isPremium());
        return attractionEntity;
    }

    public List<AttractionEntity> convertListDtoToEntity(List<AttractionDto> attractionDtos) {
        List<AttractionEntity> attractionEntities = new ArrayList<>();
        for (AttractionDto attractionDto : attractionDtos) {
            attractionEntities.add(convertDtoToAttractionEntity(attractionDto));
        }
        return attractionEntities;
    }
}

