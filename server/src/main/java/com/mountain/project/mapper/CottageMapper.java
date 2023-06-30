package com.mountain.project.mapper;

import com.mountain.project.entity.CottageEntity;
import com.mountain.project.entity.UserEntity;
import com.mountain.project.model.CottageDto;
import java.util.ArrayList;
import java.util.List;

import com.mountain.project.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class CottageMapper {
    private final UserMapper userMapper;

    public CottageMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public CottageDto convertCottageEntityToCottageDto(CottageEntity cottageEntity) {
        CottageDto cottageDto = new CottageDto();
        cottageDto.setId(cottageEntity.getId());
        cottageDto.setName(cottageEntity.getName());
        cottageDto.setDescription(cottageEntity.getDescription());
        cottageDto.setPremium(cottageEntity.getPremium());
        cottageDto.setMountain(cottageEntity.getMountain());

        List<UserDto> favouriteByUsers = userMapper.convertListUserEntityToListUserDto(cottageEntity.getFavouriteByUsers());
        cottageDto.setFavouredByUsers(favouriteByUsers);

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
        cottageEntity.setPremium(cottageDto.getPremium());
        cottageEntity.setMountain(cottageDto.getMountain());

        List<UserEntity> favouriteByUsers = userMapper.convertListUserDtoToListUserEntity(cottageDto.getFavouredByUsers());
        cottageEntity.setFavouriteByUsers(favouriteByUsers);

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

