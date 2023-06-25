package com.mountain.project.model;

public class CottageDto {

    private Long id;
    private String name;
    private String description;
    private Integer routeTo;
    private Integer routeFrom;
    private Boolean premium;

    public CottageDto() {
    }

    public CottageDto(Long id, String name, String description, Integer routeTo, Integer routeFrom, Boolean premium) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.routeTo = routeTo;
        this.routeFrom = routeFrom;
        this.premium = premium;
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

    public Integer getRouteTo() {
        return routeTo;
    }

    public void setRouteTo(Integer routeTo) {
        this.routeTo = routeTo;
    }

    public Integer getRouteFrom() {
        return routeFrom;
    }

    public void setRouteFrom(Integer routeFrom) {
        this.routeFrom = routeFrom;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }
}
