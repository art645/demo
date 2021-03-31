package com.example.testservice.demo.controller;

import com.example.testservice.demo.model.Entity;
import com.example.testservice.demo.model.EntityResource;
import com.example.testservice.demo.repository.EntityRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/db2any/bykey", produces="application/json")
public class DemoRestController {

    EntityRepositoryImpl entityRepository;

    @Autowired
    public DemoRestController(EntityRepositoryImpl entityRepository) {
        this.entityRepository = entityRepository;
    }

    @GetMapping("/getjson")
    public EntityResource getInfById(@RequestParam("key") int id) {
        if (entityRepository.findMaxId() < id) {
            return new EntityResource(null,"id not found",String.valueOf(id));
        }
        Entity entity = entityRepository.findById(id);
        return new EntityResource(entity,"ok",String.valueOf(id));
    }

}
