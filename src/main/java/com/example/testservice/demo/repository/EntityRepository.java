package com.example.testservice.demo.repository;

import com.example.testservice.demo.model.Entity;

public interface EntityRepository {
    Entity findById(int id);
    int findMaxId();
}
