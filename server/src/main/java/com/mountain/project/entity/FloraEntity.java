package com.mountain.project.entity;

import com.mountain.project.enums.Mountain;

import javax.persistence.*;

@Entity
@Table(name = "flora")
public class FloraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "edible")
    private Boolean edible;

    @Column(name = "picture")
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(name = "mountain")
    private Mountain mountain;

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

    public Boolean getEdible() {
        return edible;
    }

    public void setEdible(Boolean edible) {
        this.edible = edible;
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
}
