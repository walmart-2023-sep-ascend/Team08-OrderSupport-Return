package com.walmart.orderhist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.walmart.orderhist.constant.ApplicationConstant;

@Configuration
public class ApplicationConfig {

	@Value("${spring.data.mongodb.uri}")
	public String mongoUri;

	public MongoClient mongoClient() {
		final ConnectionString connectionString = new ConnectionString(mongoUri);
		final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString).build();
		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoDatabase mongoAscendDb(MongoClient mongoClient) {

		return mongoClient.getDatabase(ApplicationConstant.ASCEND_DATABASE);

	}

}
