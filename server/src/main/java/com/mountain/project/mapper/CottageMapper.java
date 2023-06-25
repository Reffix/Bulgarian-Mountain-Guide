package com.mountain.project.mapper;

import com.mountain.project.entity.CottageEntity;
import com.mountain.project.model.CottageDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CottageMapper {

    public CottageDto convertCottageEntityToCottageDto(CottageEntity cottageEntity) {
        CottageDto cottageDto = new CottageDto();
        cottageDto.setId(cottageEntity.getId());
        cottageDto.setName(cottageEntity.getName());
        cottageDto.setDescription(cottageEntity.getDescription());
        cottageDto.setRouteTo(cottageEntity.getRouteTo());
        cottageDto.setRouteFrom(cottageEntity.getRouteFrom());
        cottageDto.setPremium(cottageEntity.getPremium());
        return cottageDto;
    }

    public List<CottageDto> convertListCottageEntityToListCottageDto(List<CottageEntity> cottageEntities) {
        List<CottageDto> cottageDtos = new ArrayList<>();
        for (CottageEntity cottageEntity : cottageEntities) {
            cottageDtos.add(convertCottageEntityToCottageDto(cottageEntity));
        }
        return cottageDtos;
    }

    public CottageEntity convertCottageDtoToCottageEntity(CottageDto cottageDto) {
        CottageEntity cottageEntity = new CottageEntity();
        cottageEntity.setId(cottageDto.getId());
        cottageEntity.setName(cottageDto.getName());
        cottageEntity.setDescription(cottageDto.getDescription());
        cottageEntity.setRouteTo(cottageDto.getRouteTo());
        cottageEntity.setRouteFrom(cottageDto.getRouteFrom());
        cottageEntity.setPremium(cottageDto.getPremium());
        return cottageEntity;
    }

    public List<CottageEntity> convertListCottageDtoToListCottageEntity(List<CottageDto> cottageDtos) {
        List<CottageEntity> cottageEntities = new ArrayList<>();
        for (CottageDto cottageDto : cottageDtos) {
            cottageEntities.add(convertCottageDtoToCottageEntity(cottageDto));
        }
        return cottageEntities;
    }
}

