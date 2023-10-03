package com.walmart.orderhist.dao;

import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Repository
public class OrderHistDaoImpl implements OrderHistDao {

	/*
	 * @Value("${spring.data.mongodb.uri}") private String mongoUri;
	 * 
	 * 
	 * private final MongoClient mongoClient;
	 * 
	 * 
	 * 
	 * public OrderHistDaoImpl(@Qualifier("customMongoClinet") MongoClient
	 * mongoClient) { this.mongoClient = mongoClient; }
	 */

	// MongoClient mongoClient = MongoClients.create(mongoUri);

	private final MongoDatabase mongoAscendDb;

	public OrderHistDaoImpl(MongoDatabase mongoAscendDb) {

		this.mongoAscendDb = mongoAscendDb;

	}

	private static final Logger log = LoggerFactory.getLogger(OrderHistDaoImpl.class);

	public boolean validUserCheck(Integer userId) {

		MongoCollection<Document> userCollection = mongoAscendDb.getCollection("Users");

		log.info("User ID check");
		Document user = userCollection.find(Filters.eq("id", userId)).first();

		return user != null;
	}

	public AggregateIterable<Document> retrieveOrderAndItem(Integer userId) {

		MongoCollection<Document> orderCollection = mongoAscendDb.getCollection("Order");

		Bson matchStage = new Document("$match", new Document("userId", userId));

		Bson lookupStage = new Document("$lookup", new Document("from", "OrderItem").append("localField", "orderId")
				.append("foreignField", "orderId").append("as", "orderItems"));

		Bson projectStage = new Document("$project",
				new Document("_id", 0).append("orderId", 1).append("dateOfOrder", 1)
						.append("orderStatus", "$statusOfOrder").append("orderItems.items", 1)
						.append("totalAmount", "$amount").append("paymentStatus", 1).append("deliveryStatus", 1));

		AggregateIterable<Document> result = orderCollection
				.aggregate(Arrays.asList(matchStage, lookupStage, projectStage

				));

		return result;

	}

}
