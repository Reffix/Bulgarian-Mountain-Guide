package com.mountain.project.model;

import com.mountain.project.enums.Mountain;

import java.util.ArrayList;
import java.util.List;

public class HotelDto {
    private Long id;
    private String name;
    private String description;
    private Integer stars;
    private String linkToSite;
    private String picture;
    private boolean premium;
    private Mountain mountain;
    private List<UserDto> favouredByUserIds = new ArrayList<>();

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

    public List<UserDto> getFavouredByUsers() {
        return favouredByUserIds;
    }

    public void setFavouredByUsers(List<UserDto> favouredByUserIds) {
        this.favouredByUserIds = favouredByUserIds;
    }
}
