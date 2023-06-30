package com.mountain.project.model;

import com.mountain.project.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private UserRole userRole;
    private String username;
    private String password;
    private String email;
    private List<HotelDto> favouriteHotels = new ArrayList<>();
    private List<CottageDto> favouriteCottages = new ArrayList<>();
    private List<RouteDto> favouriteRoutes = new ArrayList<>();
    private List<AttractionDto> favouriteAttractions = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<HotelDto> getFavouriteHotels() {
        return favouriteHotels;
    }

    public void setFavouriteHotels(List<HotelDto> favouriteHotels) {
        this.favouriteHotels = favouriteHotels;
    }

    public List<CottageDto> getFavouriteCottages() {
        return favouriteCottages;
    }

    public void setFavouriteCottages(List<CottageDto> favouriteCottages) {
        this.favouriteCottages = favouriteCottages;
    }

    public List<RouteDto> getFavouriteRoutes() {
        return favouriteRoutes;
    }

    public void setFavouriteRoutes(List<RouteDto> favouriteRoutes) {
        this.favouriteRoutes = favouriteRoutes;
    }

    public List<AttractionDto> getFavouriteAttractions() {
        return favouriteAttractions;
    }

    public void setFavouriteAttractions(List<AttractionDto> favouriteAttractions) {
        this.favouriteAttractions = favouriteAttractions;
    }
}

