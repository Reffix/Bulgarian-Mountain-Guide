package com.mountain.project.entity;

import com.mountain.project.enums.UserRole;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", nullable = false)
    private UserRole userRole;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "favourite_hotels")
    private Integer favouriteHotels;

    @Column(name = "favourite_cottages")
    private Integer favouriteCottages;

    @Column(name = "favourite_routes")
    private Integer favouriteRoutes;

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
