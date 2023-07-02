package com.mountain.project.controller;

import com.mountain.project.Utils.JwtUtils;
import com.mountain.project.model.*;
import com.mountain.project.service.UserService;
import com.mountain.project.config.SecurityConfig.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
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
    public String login(@PathVariable("username") String username,
            @PathVariable("password") String password) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));

        UserDetails user = userService.getUserByUsername(username);
        String token = jwtUtils.generateToken(user);

        return token;
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
        List<HotelDto> favouriteHotels = userService.getFavouredHotels(userId);
        return ResponseEntity.ok(favouriteHotels);
    }

    @GetMapping("/favourites/cottages/{id}")
    public ResponseEntity<List<CottageDto>> getFavouredCottagesByUser(@PathVariable("id") Long userId) {
        List<CottageDto> favouriteCottages = userService.getFavouredCottages(userId);
        return ResponseEntity.ok(favouriteCottages);
    }

    @GetMapping("/favourites/routes/{id}")
    public ResponseEntity<List<RouteDto>> getFavouredRoutesByUser(@PathVariable("id") Long userId) {
        List<RouteDto> favouriteRoutes = userService.getFavouredRoutes(userId);
        return ResponseEntity.ok(favouriteRoutes);
    }

    @GetMapping("/favourites/attraction/{id}")
    public ResponseEntity<List<AttractionDto>> getFavouredAttractionsByUser(@PathVariable("id") Long userId) {
        List<AttractionDto> favouriteAttractions = userService.getFavouredAttractions(userId);
        return ResponseEntity.ok(favouriteAttractions);
    }

    @PutMapping("/add-favourites/{user-id}")
    public ResponseEntity<UserDto> addEntityToFavoured(@PathVariable("user-id") Long userId, @RequestBody Map<String, Object> entityInfo) {
        UserDto updatedUser = userService.addFavouredEntityToUser(userId, entityInfo);
        return ResponseEntity.ok(updatedUser);
    }
}


