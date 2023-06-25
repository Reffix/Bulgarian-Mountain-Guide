package com.mountain.project.mapper;

import com.mountain.project.entity.UserEntity;
import com.mountain.project.model.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto convertUserEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setAdmin(userEntity.isAdmin());
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        userDto.setEmail(userEntity.getEmail());
        userDto.setFavouriteHotels(userEntity.getFavouriteHotels());
        userDto.setFavouriteCottages(userEntity.getFavouriteCottages());
        userDto.setFavouriteRoutes(userEntity.getFavouriteRoutes());
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
        userEntity.setAdmin(userDto.isAdmin());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFavouriteHotels(userDto.getFavouriteHotels());
        userEntity.setFavouriteCottages(userDto.getFavouriteCottages());
        userEntity.setFavouriteRoutes(userDto.getFavouriteRoutes());
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

