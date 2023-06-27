package com.mountain.project.model;

import java.util.List;

public class CottageDto {

    private Long id;
    private String name;
    private String description;
    private Boolean premium;
    private List<UserDto> favouredByUserIds;

    public CottageDto() {
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

    public List<UserDto> getFavouredByUsers() {
        return favouredByUserIds;
    }

    public void setFavouredByUsers(List<UserDto> favouredByUserIds) {
        this.favouredByUserIds = favouredByUserIds;
    }
}
