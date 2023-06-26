package com.mountain.project.model;

public class FaunaDto {

    private Long id;
    private String name;
    private String description;
    private boolean dangerous;
    private String picture;

    public FaunaDto() {
    }

    public FaunaDto(Long id, String name, String description, boolean dangerous, String picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dangerous = dangerous;
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

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
