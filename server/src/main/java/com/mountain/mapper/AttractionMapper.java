package com.mountain.mapper;

import com.mountain.entity.AttractionEntity;
import com.mountain.model.AttractionDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AttractionMapper {

    public AttractionDto convertAttractionEntityToAttractionDto(AttractionEntity attractionEntity) {
        AttractionDto attractionDto = new AttractionDto();
        attractionDto.setId(attractionEntity.getId());
        attractionDto.setName(attractionEntity.getName());
        attractionDto.setDescription(attractionEntity.getDescription());
        attractionDto.setPremium(attractionEntity.isPremium());
        attractionDto.setPicture(attractionEntity.getPicture());
        return attractionDto;
    }

    public List<AttractionDto> convertListAttractionEntityToListAttractionDto(List<AttractionEntity> attractionEntities) {
        List<AttractionDto> attractionDtos = new ArrayList<>();
        for (AttractionEntity attractionEntity : attractionEntities) {
            attractionDtos.add(convertAttractionEntityToAttractionDto(attractionEntity));
        }
        return attractionDtos;
    }

    public AttractionEntity convertAttractionDtoToAttractionEntity(AttractionDto attractionDto) {
        AttractionEntity attractionEntity = new AttractionEntity();
        attractionEntity.setId(attractionDto.getId());
        attractionEntity.setName(attractionDto.getName());
        attractionEntity.setDescription(attractionDto.getDescription());
        attractionEntity.setPremium(attractionDto.isPremium());
        attractionEntity.setPicture(attractionDto.getPicture());
        return attractionEntity;
    }

    public List<AttractionEntity> convertListAttractionDtoToListAttractionEntity(List<AttractionDto> attractionDtos) {
        List<AttractionEntity> attractionEntities = new ArrayList<>();
        for (AttractionDto attractionDto : attractionDtos) {
            attractionEntities.add(convertAttractionDtoToAttractionEntity(attractionDto));
        }
        return attractionEntities;
    }
}
