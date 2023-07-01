package com.mountain.project.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.mountain.project.enums.Mountain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attraction")
public class AttractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "premium")
    private boolean premium;

    @Column(name = "picture")
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(name = "mountain")
    private Mountain mountain;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "favouriteAttractions")
    @JsonIdentityReference(alwaysAsId = true)
    private List<UserEntity> favouredByUsers;

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

    public List<UserEntity> getFavouredByUsers() {
        return favouredByUsers;
    }

    public void setFavouredByUsers(List<UserEntity> favouredByUsers) {
        this.favouredByUsers = favouredByUsers;
    }
}

