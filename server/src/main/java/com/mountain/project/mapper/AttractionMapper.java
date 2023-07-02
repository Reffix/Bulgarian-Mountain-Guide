package com.mountain.project.mapper;

import com.mountain.project.entity.AttractionEntity;
import com.mountain.project.entity.UserEntity;
import com.mountain.project.model.AttractionDto;
import com.mountain.project.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttractionMapper {
    private final UserMapper userMapper;

    public AttractionMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public AttractionDto convertAttractionEntityToDto(AttractionEntity attractionEntity) {
        AttractionDto attractionDto = new AttractionDto();
        attractionDto.setId(attractionEntity.getId());
        attractionDto.setName(attractionEntity.getName());
        attractionDto.setDescription(attractionEntity.getDescription());
        attractionDto.setLocation(attractionEntity.getLocation());
        attractionDto.setPremium(attractionEntity.isPremium());
        attractionDto.setPicture(attractionEntity.getPicture());
        attractionDto.setMountain(attractionEntity.getMountain());

        List<UserDto> favouriteByUsers = userMapper.convertListUserEntityToListUserDto(attractionEntity.getFavouredByUsers());
        attractionDto.setFavouredByUsers(favouriteByUsers);

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

        List<UserEntity> favouriteByUsers = userMapper.convertListUserDtoToListUserEntity(attractionDto.getFavouredByUsers());
        attractionEntity.setFavouredByUsers(favouriteByUsers);

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

