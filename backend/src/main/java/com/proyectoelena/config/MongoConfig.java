package com.proyectoelena.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableMongoAuditing
public class MongoConfig {

	@Value("${spring.data.mongodb.database:eventplatform}")
	private String database;

	@Bean
	public MongoClient mongoClient(@Value("${spring.data.mongodb.uri}") String uri) {
		return MongoClients.create(uri);
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, database);
	}
}
