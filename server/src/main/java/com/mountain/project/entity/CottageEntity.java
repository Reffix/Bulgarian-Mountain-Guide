package com.mountain.project.entity;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "premium")
    private Boolean premium;

    @ManyToMany(mappedBy = "favouriteCottages")
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

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public List<UserEntity> getFavouriteByUsers() {
        return favouredByUsers;
    }

    public void setFavouriteByUsers(List<UserEntity> favouredByUsers) {
        this.favouredByUsers = favouredByUsers;
    }
}
