package com.mountain.model;

public class AttractionDto {

    private Long id;
    private String name;
    private String description;
    private String picture;
    private boolean premium;

    public AttractionDto() {
    }

    public AttractionDto(Long id, String name, String description, boolean premium, String picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.premium = premium;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean dangerous) {
        this.premium = premium;
    }
}
