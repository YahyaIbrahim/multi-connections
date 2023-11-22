package com.example.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;

import java.net.InetSocketAddress;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 11/22/23
 **/
@Configuration
public class SecondConnectionConfig {
    @Bean("secondCqlSession")
    public CqlSession secondCqlSession() {
        return CqlSession.builder()
                .addContactPoint(new InetSocketAddress("xxx.xxx.xxx.xxx", 9042))
                .withKeyspace("keyspace")
                .withAuthCredentials("userName", "password")
                .withLocalDatacenter("localDatacenter")
                .build();
    }

    @Bean(name = "secondCassandraTemplate")
    public CassandraTemplate apacheCassandraTemplate(
            @Qualifier("secondCqlSession") CqlSession secondCqlSession,
            CassandraConverter cassandraConverter
    ) {
        return new CassandraTemplate(secondCqlSession, cassandraConverter);
    }
}
