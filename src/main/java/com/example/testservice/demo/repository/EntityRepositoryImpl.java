package com.example.testservice.demo.repository;

import com.example.testservice.demo.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class EntityRepositoryImpl implements EntityRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EntityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Entity findById(int id) {
        return jdbcTemplate.queryForObject(getQueryById("FIND_ENTITY_BY_ID"),
                new EntityRowMapper(), id);
    }

    @Override
    public int findMaxId() {
        return jdbcTemplate.queryForObject(getQueryById("FIND_MAX_ID"),Integer.class);
    }

    private Object getBeanFromFactory(String beanId) {
        Object obj = null;
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:web.xml");
        if (ctx != null && beanId != null) {
            obj = ctx.getBean(beanId);
        }

        return obj;
    }

    private String getQueryById(String queryId) {

        Map queryMap = null;
        String query = null;
        queryMap = (Map) this.getBeanFromFactory("queries");
        query = (String) queryMap.get(queryId);
        return query;
    }

}
