package com.mountain.project.service;

import com.mountain.project.entity.*;
import com.mountain.project.mapper.*;
import com.mountain.project.model.*;
import com.mountain.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final HotelMapper hotelMapper;
    private final CottageMapper cottageMapper;
    private final RouteMapper routeMapper;
    private final AttractionMapper attractionMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, HotelMapper hotelMapper, CottageMapper cottageMapper, RouteMapper routeMapper, AttractionMapper attractionMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.hotelMapper = hotelMapper;
        this.cottageMapper = cottageMapper;
        this.routeMapper = routeMapper;
        this.attractionMapper = attractionMapper;
    }

    public UserDto getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
        UserDto userDto = userMapper.convertUserEntityToDto(userEntity);
        handleFavouriteMembersFromEntityToDto(userDto, userEntity);

        return userMapper.convertUserEntityToDto(userEntity);
    }

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.convertUserDtoToEntity(userDto);
        handleFavouriteMembersFromDtoToEntity(userEntity, userDto);

        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.convertUserEntityToDto(savedUserEntity);
    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        userEntity.setAdmin(userDto.isAdmin());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        handleFavouriteMembersFromDtoToEntity(userEntity, userDto);

        UserEntity updatedUserEntity = userRepository.save(userEntity);
        return userMapper.convertUserEntityToDto(updatedUserEntity);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void handleFavouriteMembersFromDtoToEntity(UserEntity userEntity, UserDto userDto) {
        List<HotelEntity> favouriteHotels = hotelMapper.convertListHotelDtoToListHotelEntity(userDto.getFavouriteHotels());
        List<CottageEntity> favouriteCottages = cottageMapper.convertListCottageDtoToListCottageEntity(userDto.getFavouriteCottages());
        List<RouteEntity> favouriteRoutes = routeMapper.convertListRouteDtoToListRouteEntity(userDto.getFavouriteRoutes());
        List<AttractionEntity> favouriteAttractions = attractionMapper.convertListDtoToEntity(userDto.getFavouriteAttractions());

        userEntity.setFavouriteHotels(favouriteHotels);
        userEntity.setFavouriteCottages(favouriteCottages);
        userEntity.setFavouriteRoutes(favouriteRoutes);
        userEntity.setFavouriteAttractions(favouriteAttractions);
    }

    public void handleFavouriteMembersFromEntityToDto(UserDto userDto, UserEntity userEntity) {
        List<HotelDto> favouriteHotels = hotelMapper.convertListHotelEntityToListHotelDto(userEntity.getFavouriteHotels());
        List<CottageDto> favouriteCottages = cottageMapper.convertListCottageEntityToListCottageDto(userEntity.getFavouriteCottages());
        List<RouteDto> favouriteRoutes = routeMapper.convertListRouteEntityToListRouteDto(userEntity.getFavouriteRoutes());
        List<AttractionDto> favouriteAttractions = attractionMapper.convertListEntityToDto(userEntity.getFavouriteAttractions());

        userDto.setFavouriteHotels(favouriteHotels);
        userDto.setFavouriteCottages(favouriteCottages);
        userDto.setFavouriteRoutes(favouriteRoutes);
        userDto.setFavouriteAttractions(favouriteAttractions);
    }
}


