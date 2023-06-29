package com.mountain.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "routes")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private Integer type;

    @Column(name = "startpoint")
    private String startPoint;

    @Column(name = "endpoint")
    private String endPoint;

    @Column(name = "distance")
    private Float distance;

    @Column(name = "denivelation")
    private Float denivelation;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "favouriteRoutes")
    private List<UserEntity> favouredByUsers;

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

    public List<UserEntity> getFavouredByUsers() {
        return favouredByUsers;
    }

    public void setFavouredByUsers(List<UserEntity> favouredByUsers) {
        this.favouredByUsers = favouredByUsers;
    }
}

