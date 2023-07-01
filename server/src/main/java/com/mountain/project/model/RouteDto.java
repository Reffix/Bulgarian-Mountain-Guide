package com.mountain.project.model;

import com.mountain.project.enums.Mountain;

import java.util.ArrayList;
import java.util.List;

public class RouteDto {

    private Long id;
    private Integer type;
    private String startPoint;
    private String endPoint;
    private Float distance;
    private Float denivelation;
    private Mountain mountain;
    private List<UserDto> favouredByUserIds = new ArrayList<>();

    public RouteDto() {
    }

    public RouteDto(Long id, Integer type, String startPoint, String endPoint, Float distance, Float denivelation, Mountain mountain) {
        this.id = id;
        this.type = type;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
        this.denivelation = denivelation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getDenivelation() {
        return denivelation;
    }

    public void setDenivelation(Float denivelation) {
        this.denivelation = denivelation;
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

