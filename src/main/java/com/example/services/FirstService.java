package com.example.services;

import com.example.entities.FirstEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 11/22/23
 **/
@Service
@Slf4j
@AllArgsConstructor
public class FirstService {

    @Qualifier("firstCassandraTemplate")
    private final CassandraTemplate firstCassandraTemplate;

    public List<FirstEntity> getAll(){
        return firstCassandraTemplate.select("select * from firstEntity",FirstEntity.class);
    }
}
