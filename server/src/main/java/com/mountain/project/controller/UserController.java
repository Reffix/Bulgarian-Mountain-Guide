package com.mountain.project.controller;

import com.mountain.project.enums.Mountain;
import com.mountain.project.model.*;
import com.mountain.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/favourites/hotels/{id}")
    public List<HotelDto> getFavouredHotelsByUser(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return user.getFavouriteHotels();
    }

    @GetMapping("/favourites/cottages/{id}")
    public List<CottageDto> getFavouredCottagesByUser(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return user.getFavouriteCottages();
    }

    @GetMapping("/favourites/routes/{id}")
    public List<RouteDto> getFavouredRoutesByUser(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        return user.getFavouriteRoutes();
    }

    @PutMapping("/favourites/hotels/{id}")
    public ResponseEntity<UserDto> addHotelToFavoured(@PathVariable("id") Long userId, @PathVariable Map<String, Object> entityInfo) {
        UserDto updatedUser = userService.addFavouredEntityToUser(userId, entityInfo);
        return ResponseEntity.ok(updatedUser);
    }
}


