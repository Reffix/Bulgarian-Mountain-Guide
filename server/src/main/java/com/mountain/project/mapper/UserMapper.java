package com.mountain.project.mapper;

import com.mountain.project.entity.UserEntity;
import com.mountain.project.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDto convertUserEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUserRole(userEntity.getUserRole());
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        userDto.setEmail(userEntity.getEmail());

        //many to many relations will be handled in the service layer
        userDto.setFavouriteHotels(null);
        userDto.setFavouriteCottages(null);
        userDto.setFavouriteRoutes(null);
        userDto.setFavouriteAttractions(null);

        return userDto;
    }

    public List<UserDto> convertListUserEntityToListUserDto(List<UserEntity> userEntities) {
        List<UserDto> userDtos = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userDtos.add(convertUserEntityToDto(userEntity));
        }
        return userDtos;
    }

    public UserEntity convertUserDtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setUserRole(userDto.getUserRole());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());

        //many to many relations will be handled in the service layer
        userEntity.setFavouriteHotels(null);
        userEntity.setFavouriteCottages(null);
        userEntity.setFavouriteRoutes(null);
        userEntity.setFavouriteAttractions(null);

        return userEntity;
    }

    public List<UserEntity> convertListUserDtoToListUserEntity(List<UserDto> userDtos) {
        List<UserEntity> userEntities = new ArrayList<>();
        for (UserDto userDto : userDtos) {
            userEntities.add(convertUserDtoToEntity(userDto));
        }
        return userEntities;
    }

}

