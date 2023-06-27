package com.mountain.project.mapper;

import com.mountain.project.entity.*;
import com.mountain.project.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final HotelMapper hotelMapper;
    private final CottageMapper cottageMapper;
    private final RouteMapper routeMapper;
    private final AttractionMapper attractionMapper;

    public UserMapper(HotelMapper hotelMapper, CottageMapper cottageMapper, RouteMapper routeMapper, AttractionMapper attractionMapper) {
        this.hotelMapper = hotelMapper;
        this.cottageMapper = cottageMapper;
        this.routeMapper = routeMapper;
        this.attractionMapper = attractionMapper;
    }

    public UserDto convertUserEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setAdmin(userEntity.isAdmin());
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        userDto.setEmail(userEntity.getEmail());

        List<HotelDto> favouriteHotels = hotelMapper.convertListHotelEntityToListHotelDto(userEntity.getFavouriteHotels());
        List<CottageDto> favouriteCottages = cottageMapper.convertListCottageEntityToListCottageDto(userEntity.getFavouriteCottages());
        List<RouteDto> favouriteRoutes = routeMapper.convertListRouteEntityToListRouteDto(userEntity.getFavouriteRoutes());
        List<AttractionDto> favouriteAttractions = attractionMapper.convertListEntityToDto(userEntity.getFavouriteAttractions());

        userDto.setFavouriteHotels(favouriteHotels);
        userDto.setFavouriteCottages(favouriteCottages);
        userDto.setFavouriteRoutes(favouriteRoutes);
        userDto.setFavouriteAttractions(favouriteAttractions);

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

        List<HotelEntity> favouriteHotels = hotelMapper.convertListHotelDtoToListHotelEntity(userDto.getFavouriteHotels());
        List<CottageEntity> favouriteCottages = cottageMapper.convertListCottageDtoToListCottageEntity(userDto.getFavouriteCottages());
        List<RouteEntity> favouriteRoutes = routeMapper.convertListRouteDtoToListRouteEntity(userDto.getFavouriteRoutes());
        List<AttractionEntity> favouriteAttractions = attractionMapper.convertListDtoToEntity(userDto.getFavouriteAttractions());

        userEntity.setFavouriteHotels(favouriteHotels);
        userEntity.setFavouriteCottages(favouriteCottages);
        userEntity.setFavouriteRoutes(favouriteRoutes);
        userEntity.setFavouriteAttractions(favouriteAttractions);

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

