package com.example.testservice.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Entity {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("VALUE")
    private String value;

    public Entity(int id, String value) {
        this.id = id;
        this.value = value;
    }
}
