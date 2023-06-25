package com.mountain.project.model;

public class CottageDto {

    private Long id;
    private String name;
    private String description;
    private Boolean premium;

    public CottageDto() {
    }

    public CottageDto(Long id, String name, String description, Boolean premium) {
        this.id = id;
        this.name = name;
        this.description = description;
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



    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }
}
