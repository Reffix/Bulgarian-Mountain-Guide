package com.mountain.project.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.mountain.project.enums.Mountain;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "mountain")
    private Mountain mountain;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "favouriteCottages")
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

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public List<UserEntity> getFavouriteByUsers() {
        return favouredByUsers;
    }

    public void setFavouriteByUsers(List<UserEntity> favouredByUsers) {
        this.favouredByUsers = favouredByUsers;
    }
}
