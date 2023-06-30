package com.mountain.project.model;

import java.util.ArrayList;
import java.util.List;

import com.mountain.project.enums.Mountain;

public class CottageDto {

    private Long id;
    private String name;
    private String description;
    private Boolean premium;
    private Mountain mountain;
    private List<UserDto> favouredByUserIds = new ArrayList<>();

    public CottageDto() {
    }

    public CottageDto(Long id, String name, String description, Boolean premium, Mountain mountain) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.premium = premium;
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

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
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
