package com.mountain.project.model;

public class AttractionDto {

    private Long id;
    private String name;
    private String description;
    private String location;
    private boolean premium;

    public AttractionDto() {
    }

    public AttractionDto(Long id, String name, String description, String location, boolean premium) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
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
}

