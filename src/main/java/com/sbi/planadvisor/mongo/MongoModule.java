package com.sbi.planadvisor.mongo;

import com.google.common.collect.ImmutableList;
import com.mongodb.*;
import com.sbi.planadvisor.configuration.MongoConfiguration;
import org.jongo.Jongo;
import org.jongo.Mapper;
import org.jongo.MongoCollection;
import org.jongo.marshall.jackson.JacksonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.time.Instant;


@Configuration
public class MongoModule {
    @Autowired
    private MongoConfiguration configuration;

    @Bean
    public MongoClient provideMongoClient() throws UnknownHostException {
        MongoClient mongoClient = null;
        ImmutableList.Builder<ServerAddress> addresses = ImmutableList.builder();
        addresses.add(new ServerAddress(configuration.getHost(), configuration.getPort()));
        mongoClient = new MongoClient(addresses.build());
        return mongoClient;
    }

    @Bean
    public Jongo provideJongo(MongoClient mongo, Mapper mapper) {
        return new Jongo(mongo.getDB(configuration.getDb()), mapper);
    }

    @Bean
    public Mapper provideJongoMapper() {
        return new JacksonMapper.Builder()
                .addSerializer(Instant.class, new BsonInstantSerializer())
                .addSerializer(BigDecimal.class, new BsonBigDecimalSerializer())
                .addDeserializer(Instant.class, new JsonInstantDeserializer())
                .addDeserializer(BigDecimal.class, new JsonBigDecimalDeSerializer())
                .build();
    }

    @Bean(name = "ageFundMapping")
    public MongoCollection provideSubscriptions(Jongo jongo) {
        return jongo.getCollection("ageFundMappings");
    }

    @Bean(name= "ageRisk")
    public MongoCollection getAgeRisk(Jongo jongo) {
    	return jongo.getCollection("ageRisk");
    }
    
    @Bean(name= "locationRisk")
    public MongoCollection getLocationRisk(Jongo jongo) {
    	return jongo.getCollection("locationRisk");
    }
    
    @Bean(name= "martialStatusRisk")
    public MongoCollection getMartialStatusRisk(Jongo jongo) {
    	return jongo.getCollection("martialStatusRisk");
    }
    
    @Bean(name= "annualIncomeRisk")
    public MongoCollection getAnnualRisk(Jongo jongo) {
    	return jongo.getCollection("annualIncomeRisk");
    }
    
    @Bean(name= "finalRisk")
    public MongoCollection getFinalRisk(Jongo jongo) {
    	return jongo.getCollection("finalRisk");
    }
    
}
