package com.mountain.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "user_favorite_hotel",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    private List<HotelEntity> favouriteHotels;

    @ManyToMany
    @JoinTable(
            name = "user_favourite_cottage",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "cottage_id"))
    private List<CottageEntity> favouriteCottages;

    @ManyToMany
    @JoinTable(
            name = "user_favourite_route",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<RouteEntity> favouriteRoutes;

    @ManyToMany
    @JoinTable(
            name = "user_favourite_attraction",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "attraction_id"))
    private List<AttractionEntity> favouriteAttractions;

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

    public List<HotelEntity> getFavouriteHotels() {
        return favouriteHotels;
    }

    public void setFavouriteHotels(List<HotelEntity> favouriteHotels) {
        this.favouriteHotels = favouriteHotels;
    }

    public List<CottageEntity> getFavouriteCottages() {
        return favouriteCottages;
    }

    public void setFavouriteCottages(List<CottageEntity> favouriteCottages) {
        this.favouriteCottages = favouriteCottages;
    }

    public List<RouteEntity> getFavouriteRoutes() {
        return favouriteRoutes;
    }

    public void setFavouriteRoutes(List<RouteEntity> favouriteRoutes) {
        this.favouriteRoutes = favouriteRoutes;
    }

    public List<AttractionEntity> getFavouriteAttractions() {
        return favouriteAttractions;
    }

    public void setFavouriteAttractions(List<AttractionEntity> favouriteAttractions) {
        this.favouriteAttractions = favouriteAttractions;
    }
}
