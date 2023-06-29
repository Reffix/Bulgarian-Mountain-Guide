package com.mountain.project.model;

import com.mountain.project.enums.UserRole;

public class UserDto {

    private Long id;
    private UserRole userRole;
    private String username;
    private String password;
    private String email;
    private Integer favouriteHotels;
    private Integer favouriteCottages;
    private Integer favouriteRoutes;

    public UserDto() {
    }

    public UserDto(Long id, UserRole userRole, String username, String password, String email, Integer favouriteHotels,
            Integer favouriteCottages, Integer favouriteRoutes) {
        this.id = id;
        this.userRole = userRole;
        this.username = username;
        this.password = password;
        this.email = email;
        this.favouriteHotels = favouriteHotels;
        this.favouriteCottages = favouriteCottages;
        this.favouriteRoutes = favouriteRoutes;
    }

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

    public Integer getFavouriteHotels() {
        return favouriteHotels;
    }

    public void setFavouriteHotels(Integer favouriteHotels) {
        this.favouriteHotels = favouriteHotels;
    }

    public Integer getFavouriteCottages() {
        return favouriteCottages;
    }

    public void setFavouriteCottages(Integer favouriteCottages) {
        this.favouriteCottages = favouriteCottages;
    }

    public Integer getFavouriteRoutes() {
        return favouriteRoutes;
    }

    public void setFavouriteRoutes(Integer favouriteRoutes) {
        this.favouriteRoutes = favouriteRoutes;
    }
}

