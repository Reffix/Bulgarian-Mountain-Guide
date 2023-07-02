package com.mountain.project.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.mountain.project.enums.Mountain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "link_to_website")
    private String linkToSite;

    @Column(name = "picture")
    private String picture;

    @Column(name = "premium")
    private boolean premium;

    @Enumerated(EnumType.STRING)
    @Column(name = "mountain")
    private Mountain mountain;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "favouriteHotels")
    @JsonIdentityReference(alwaysAsId = true)
    private List<UserEntity> favouredByUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getLinkToSite() {
        return linkToSite;
    }

    public void setLinkToSite(String linkToSite) {
        this.linkToSite = linkToSite;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public List<UserEntity> getFavouredByUsers() {
        return favouredByUsers;
    }

    public void setFavouredByUsers(List<UserEntity> favouredByUsers) {
        this.favouredByUsers = favouredByUsers;
    }
}
