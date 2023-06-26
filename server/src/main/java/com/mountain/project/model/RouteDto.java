package com.mountain.project.model;

public class RouteDto {

    private Long id;
    private Integer type;
    private String startPoint;
    private String endPoint;
    private Float distance;
    private Float denivelation;

    public RouteDto() {
    }

    public RouteDto(Long id, Integer type, String startPoint, String endPoint, Float distance, Float denivelation) {
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
}

