package com.mountain.project.service;

import com.mountain.project.entity.UserEntity;
import com.mountain.project.mapper.UserMapper;
import com.mountain.project.model.UserDto;
import com.mountain.project.repository.UserRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
        return userMapper.convertUserEntityToDto(userEntity);
    }

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.convertUserDtoToEntity(userDto);
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
        userEntity.setFavouriteHotels(userDto.getFavouriteHotels());
        userEntity.setFavouriteCottages(userDto.getFavouriteCottages());
        userEntity.setFavouriteRoutes(userDto.getFavouriteRoutes());

        UserEntity updatedUserEntity = userRepository.save(userEntity);
        return userMapper.convertUserEntityToDto(updatedUserEntity);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}


