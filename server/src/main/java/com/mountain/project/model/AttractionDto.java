package com.mountain.project.model;

import com.mountain.project.enums.Mountain;

import java.util.List;

public class AttractionDto {

    private Long id;
    private String name;
    private String description;
    private String location;
    private boolean premium;
    private List<UserDto> favouredByUserIds;

    private String picture;

    private Mountain mountain;

    public AttractionDto() {
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

