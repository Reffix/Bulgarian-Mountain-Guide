package com.mountain.project.service;

import com.mountain.project.entity.UserEntity;
import com.mountain.project.enums.UserRole;
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

    public UserDto login(String username, String password) {
        UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new EntityNotFoundException("Invalid credentials"));

        return userMapper.convertUserEntityToDto(userEntity);
    }

    public UserDto register(String username, String password, String email) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setUserRole(UserRole.USER);

        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.convertUserEntityToDto(savedUserEntity);
    }
}


