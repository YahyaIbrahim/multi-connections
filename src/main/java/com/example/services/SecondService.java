package com.example.services;

import com.example.entities.FirstEntity;
import com.example.entities.SecondEntity;
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
public class SecondService {

    @Qualifier("secondCassandraTemplate")
    private final CassandraTemplate secondCassandraTemplate;

    public List<SecondEntity> getAll(){
        return secondCassandraTemplate.select("select * from secondEntity",SecondEntity.class);
    }
}
