package com.mountain.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cottages")
public class CottageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "route_to")
    private Integer routeTo;

    @Column(name = "route_from")
    private Integer routeFrom;

    @Column(name = "premium")
    private Boolean premium;

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
