package com.walmart.orderhist.dao;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;

public interface OrderHistDao {
	public boolean validUserCheck(Integer userId);
	public AggregateIterable<Document> retrieveOrderAndItem(Integer userId);

}
