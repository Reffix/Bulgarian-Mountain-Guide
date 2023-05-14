package com.mountain.mapper;

import com.mountain.entity.LandmarkEntity;
import com.mountain.model.LandmarkDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class LandmarkMapper {

    public LandmarkDto convertLandmarkEntityToLandmarkDto(LandmarkEntity landmarkEntity) {
        LandmarkDto landmarkDto = new LandmarkDto();
        landmarkDto.setId(landmarkEntity.getId());
        landmarkDto.setName(landmarkEntity.getName());
        landmarkDto.setDescription(landmarkEntity.getDescription());
        landmarkDto.setLocation(landmarkEntity.getLocation());
        return landmarkDto;
    }

    public List<LandmarkDto> convertListLandmarkEntityToListLandmarkDto(List<LandmarkEntity> landmarkEntities) {
        return landmarkEntities.stream()
                .map(this::convertLandmarkEntityToLandmarkDto)
                .collect(Collectors.toList());
    }

    public LandmarkEntity convertLandmarkDtoToLandmarkEntity(LandmarkDto landmarkDto) {
        LandmarkEntity landmarkEntity = new LandmarkEntity();
        landmarkEntity.setId(landmarkDto.getId());
        landmarkEntity.setName(landmarkDto.getName());
        landmarkEntity.setDescription(landmarkDto.getDescription());
        landmarkEntity.setLocation(landmarkDto.getLocation());
        return landmarkEntity;
    }

    public List<LandmarkEntity> convertListLandmarkDtoToListLandmarkEntity(List<LandmarkDto> landmarkDtos) {
        return landmarkDtos.stream()
                .map(this::convertLandmarkDtoToLandmarkEntity)
                .collect(Collectors.toList());
    }
}
