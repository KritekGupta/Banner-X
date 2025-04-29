package com.BannerX.BannerX.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;

@Configuration
public class MongoConfig {


    @Primary
    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory) {
        return new MongoTemplate(databaseFactory);
    }

    @Bean(name = "formMongoTemplate")
    public MongoTemplate formMongoTemplate() throws Exception {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://kritek:kritek123@cluster0.k6qzi03.mongodb.net/Form");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(mongoClientSettings);
        MongoDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(mongoClient, "Form");
        return new MongoTemplate(factory);
    }
}

