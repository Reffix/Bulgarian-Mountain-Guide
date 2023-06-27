package com.mountain.project.model;

import java.util.List;

public class UserDto {

    private Long id;
    private boolean isAdmin;
    private String username;
    private String password;
    private String email;
    private List<HotelDto> favouriteHotels;
    private List<CottageDto> favouriteCottages;
    private List<RouteDto> favouriteRoutes;
    private List<AttractionDto> favouriteAttractions;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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

