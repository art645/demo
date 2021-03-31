package com.example.testservice.demo.model;


import lombok.Data;

@Data
public class EntityResource {
    private Entity data;
    private String response;
    private String request;

    public EntityResource(Entity data, String response, String request) {
        this.data = data;
        this.response = response;
        this.request = request;
    }
}
