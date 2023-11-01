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
import com.walmart.orderhist.constant.ApplicationConstant;

@Repository
public class OrderHistDaoImpl implements OrderHistDao {

	private final MongoDatabase mongoAscendDb;

	public OrderHistDaoImpl(MongoDatabase mongoAscendDb) {

		this.mongoAscendDb = mongoAscendDb;

	}

	private static final Logger log = LoggerFactory.getLogger(OrderHistDaoImpl.class);
	
	

	public boolean validUserCheck(Integer userId) {

		MongoCollection<Document> userCollection = mongoAscendDb.getCollection(ApplicationConstant.USER_COLLECTION);

		log.info("User ID check");
		Document user = userCollection.find(Filters.eq(ApplicationConstant.ID, userId)).first();

		return user != null;
	}

	public AggregateIterable<Document> retrieveOrderAndItem(Integer userId) {

		MongoCollection<Document> orderCollection = mongoAscendDb.getCollection(ApplicationConstant.ORDER_COLLECTION);

		Bson matchStage = new Document("$match", new Document(ApplicationConstant.USER_ID , userId));

		Bson lookupStage = new Document("$lookup",
				new Document("from", "OrderItem").append("localField", ApplicationConstant.ORDER_ID)
						.append("foreignField", ApplicationConstant.ORDER_ID).append("as", "orderItems"));

		Bson projectStage = new Document("$project",
				new Document("_id", 0).append(ApplicationConstant.ORDER_ID, 1).append("dateOfOrder", 1)
						.append(ApplicationConstant.ORDER_STATUS, "$statusOfOrder").append("orderItems.items", 1)
						.append("totalAmount", "$amount").append("paymentStatus", 1).append("deliveryStatus", 1));

		return orderCollection.aggregate(Arrays.asList(matchStage, lookupStage, projectStage));

	}

}
