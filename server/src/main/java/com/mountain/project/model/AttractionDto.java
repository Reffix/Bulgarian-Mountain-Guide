package com.mountain.project.model;

import com.mountain.project.enums.Mountain;

public class AttractionDto {

    private Long id;
    private String name;
    private String description;
    private String location;
    private boolean premium;

    private String picture;

    private Mountain mountain;

    public AttractionDto() {
    }

    public AttractionDto(Long id, String name, String description, String location, boolean premium, String picture,
            Mountain mountain) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.premium = premium;
        this.picture = picture;
        this.mountain = mountain;
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
}

