package com.mountain.project.controller;

import com.mountain.project.enums.Mountain;
import com.mountain.project.model.*;
import com.mountain.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login/{username}/{password}")
    public ResponseEntity<UserDto> login(@PathVariable("username") String username,
            @PathVariable("password") String password) {
        UserDto loggedInUser = userService.login(username, password);
        return ResponseEntity.ok(loggedInUser);
    }

    @PostMapping("/register/{username}/{password}/{email}")
    public ResponseEntity<UserDto> register(@PathVariable("username") String username,
            @PathVariable("password") String password,
            @PathVariable("email") String email) {
        UserDto registeredUser = userService.register(username, password, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @GetMapping("/favourites/hotels/{id}")
    public ResponseEntity<List<HotelDto>> getFavouredHotelsByUser(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        List<HotelDto> favouriteHotels = user.getFavouriteHotels();

        return ResponseEntity.ok(favouriteHotels);
    }

    @GetMapping("/favourites/cottages/{id}")
    public ResponseEntity<List<CottageDto>> getFavouredCottagesByUser(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        List<CottageDto> favouriteCottages = user.getFavouriteCottages();

        return ResponseEntity.ok(favouriteCottages);
    }

    @GetMapping("/favourites/routes/{id}")
    public ResponseEntity<List<RouteDto>> getFavouredRoutesByUser(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        List<RouteDto> favouriteRoutes = user.getFavouriteRoutes();

        return ResponseEntity.ok(favouriteRoutes);
    }

    @GetMapping("/favourites/attraction/{id}")
    public ResponseEntity<List<AttractionDto>> getFavouredAttractionsByUser(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);
        List<AttractionDto> favouriteAttractions = user.getFavouriteAttractions();

        return ResponseEntity.ok(favouriteAttractions);
    }

    @PutMapping("/add-favourites/{user-id}")
    public ResponseEntity<UserDto> addEntityToFavoured(@PathVariable("user-id") Long userId, @RequestBody Map<String, Object> entityInfo) {
        UserDto updatedUser = userService.addFavouredEntityToUser(userId, entityInfo);
        return ResponseEntity.ok(updatedUser);
    }
}


