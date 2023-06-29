package com.mountain.project.model;

import java.util.ArrayList;
import java.util.List;

public class RouteDto {

    private Long id;
    private Integer type;
    private String startPoint;
    private String endPoint;
    private Float distance;
    private Float denivelation;
    private List<UserDto> favouredByUsers = new ArrayList<>();

    public RouteDto() {
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

    public List<UserDto> getFavouredByUsers() {
        return favouredByUsers;
    }

    public void setFavouredByUsers(List<UserDto> favouredByUserIds) {
        this.favouredByUsers = favouredByUserIds;
    }
}

