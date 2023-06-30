package com.mountain.project.model;

import com.mountain.project.enums.Mountain;

public class LandmarkDto {

    private Long id;
    private String name;
    private String description;
    private String location;
    private Mountain mountain;

    public LandmarkDto() {
    }

    public LandmarkDto(Long id, String name, String description, String location, Mountain mountain) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
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

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }
}
