package com.juicyCore.eCatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDTO {
    public CategoryDTO() {
    }
    private Long id;
    private String name;
    private String type;

    public CategoryDTO(
                         @JsonProperty("name") String name,
                         @JsonProperty("type") String type)
    {
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
