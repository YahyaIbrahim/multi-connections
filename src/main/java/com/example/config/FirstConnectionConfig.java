package com.example.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 11/22/23
 **/
@Configuration
public class FirstConnectionConfig {

    @Primary
    @Bean(name = "firstCqlSession")
    public CqlSession firstCqlSession() throws Exception {
        return CqlSession.builder()
                .withConfigLoader(DriverConfigLoader.fromUrl(new ClassPathResource("yourCassandraConfigFile.conf").getURL()))
                .withAuthCredentials("yourUserName", "yourPassword")
                .withKeyspace("keyspace")
                .withLocalDatacenter("localDatacenter") // replace localDatacenter with your datacenter if exists
                .build();
    }



    @Primary
    @Bean(name = "firstCassandraTemplate")
    public CassandraTemplate awsCassandraTemplate(
            @Qualifier("firstCqlSession") CqlSession firstCqlSession,
            CassandraConverter cassandraConverter
    ) {
        return new CassandraTemplate(firstCqlSession, cassandraConverter);
    }




}
