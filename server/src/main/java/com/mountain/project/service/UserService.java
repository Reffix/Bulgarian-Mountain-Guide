package com.mountain.project.service;

import com.mountain.project.entity.*;
import com.mountain.project.mapper.*;
import com.mountain.project.model.*;
import com.mountain.project.repository.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;
    private final CottageRepository cottageRepository;
    private final RouteRepository routeRepository;
    private final AttractionRepository attractionRepository;

    private final UserMapper userMapper;
    private final HotelMapper hotelMapper;
    private final CottageMapper cottageMapper;
    private final RouteMapper routeMapper;
    private final AttractionMapper attractionMapper;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       HotelRepository hotelRepository,
                       CottageRepository cottageRepository,
                       RouteRepository routeRepository,
                       AttractionRepository attractionRepository,
                       UserMapper userMapper,
                       HotelMapper hotelMapper,
                       CottageMapper cottageMapper,
                       RouteMapper routeMapper,
                       AttractionMapper attractionMapper,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.hotelRepository = hotelRepository;
        this.cottageRepository = cottageRepository;
        this.routeRepository = routeRepository;
        this.attractionRepository = attractionRepository;
        this.userMapper = userMapper;
        this.hotelMapper = hotelMapper;
        this.cottageMapper = cottageMapper;
        this.routeMapper = routeMapper;
        this.attractionMapper = attractionMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
        UserDto userDto = userMapper.convertUserEntityToDto(userEntity);
        handleFavouriteMembersFromEntityToDto(userDto, userEntity);

        return userMapper.convertUserEntityToDto(userEntity);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found with username: " + username));
    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        userEntity.setUserRole(userDto.getUserRole());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        handleFavouriteMembersFromDtoToEntity(userEntity, userDto);

        UserEntity updatedUserEntity = userRepository.save(userEntity);
        UserDto result = userMapper.convertUserEntityToDto(updatedUserEntity);
        handleFavouriteMembersFromEntityToDto(result,updatedUserEntity);

        return result;
    }

    public UserDto login(String username, String password) {
        UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new EntityNotFoundException("Invalid credentials"));

        return userMapper.convertUserEntityToDto(userEntity);
    }

    public void register(RegistrationDto registrationDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registrationDto.getUsername());
        userEntity.setEmail(registrationDto.getEmail());
        userEntity.setUserRole(registrationDto.getUserRole());

        String hashedPassword = passwordEncoder.encode(registrationDto.getPassword());
        userEntity.setPassword(hashedPassword);

        UserEntity savedUserEntity = userRepository.save(userEntity);
    }

    @Transactional
    public UserDto addFavouredEntityToUser(Long userId, Map<String, Object> entityInfo) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        try {
            Long entityId = Long.valueOf(entityInfo.get("entity_id").toString());
            String entityType = (String) entityInfo.get("type");

            switch (entityType) {
                case "hotel" -> {
                    HotelEntity hotelEntity = hotelRepository.findById(entityId)
                            .orElseThrow(() -> new EntityNotFoundException("Hotel not found with ID: " + entityId));
                    userEntity.getFavouriteHotels().add(hotelEntity);
                }
                case "cottage" -> {
                    CottageEntity cottageEntity = cottageRepository.findById(entityId)
                            .orElseThrow(() -> new EntityNotFoundException("Cottage not found with ID: " + entityId));
                    userEntity.getFavouriteCottages().add(cottageEntity);
                }
                case "route" -> {
                    RouteEntity routeEntity = routeRepository.findById(entityId)
                            .orElseThrow(() -> new EntityNotFoundException("Route not found with ID: " + entityId));
                    userEntity.getFavouriteRoutes().size();
                    userEntity.getFavouriteRoutes().add(routeEntity);
                }
                case "attraction" -> {
                    AttractionEntity attractionEntity = attractionRepository.findById(entityId)
                            .orElseThrow(() -> new EntityNotFoundException("Attraction not found with ID: " + entityId));
                    userEntity.getFavouriteAttractions().add(attractionEntity);
                }
                default -> throw new IllegalStateException("Unexpected value: " + entityType);
            }

            UserEntity updatedUserEntity = userRepository.save(userEntity);
            UserDto result = userMapper.convertUserEntityToDto(updatedUserEntity);
            handleFavouriteMembersFromEntityToDto(result, updatedUserEntity);
            return result;

        } catch (ClassCastException ex) {
            System.out.println("[User Service] Failed to cast in addFavouredEntityToUser()");
        }

        return userMapper.convertUserEntityToDto(userEntity);
    }

    public List<HotelDto> getFavouredHotels(Long userId) {
        List<HotelEntity> hotelEntities = userRepository.findAllFavouredHotelsByUserId(userId);
        if (hotelEntities != null) {
            return hotelMapper.convertListHotelEntityToListHotelDto(hotelEntities);
        }

        return new ArrayList<>();
    }

    public List<CottageDto> getFavouredCottages(Long userId) {
        List<CottageEntity> cottageEntities = userRepository.findAllFavouredCottagesByUserId(userId);
        if (cottageEntities != null) {
            return cottageMapper.convertListCottageEntityToListCottageDto(cottageEntities);
        }

        return new ArrayList<>();
    }

    public List<RouteDto> getFavouredRoutes(Long userId) {
        List<RouteEntity> routeEntities = userRepository.findFavouriteRoutesByUserId(userId);
        if (routeEntities != null) {
            return routeMapper.convertListRouteEntityToListRouteDto(routeEntities);
        }

        return new ArrayList<>();
    }

    public List<AttractionDto> getFavouredAttractions(Long userId) {
        List<AttractionEntity> attractionEntities = userRepository.findAllFavouredAttractionsByUserId(userId);
        if (attractionEntities != null) {
            return attractionMapper.convertListEntityToDto(attractionEntities);
        }

        return new ArrayList<>();
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


