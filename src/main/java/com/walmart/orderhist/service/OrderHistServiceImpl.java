package com.walmart.orderhist.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.walmart.orderhist.config.ApplicationConfig;
import com.walmart.orderhist.dao.OrderHistDao;

@Service
public class OrderHistServiceImpl implements OrderHistService {

	@Autowired
	private OrderHistDao orderHistDao;
	
    @Autowired
    private ObjectMapper objectMapper;

	public boolean validUserCheck(Integer userId) {

		return orderHistDao.validUserCheck(userId);
	}

	public ResponseEntity<String> orderHist(Integer userId) {

		if (validUserCheck(userId)) {

			AggregateIterable<Document> result = orderHistDao.retrieveOrderAndItem(userId);

			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

			for (Document document : result) {

				resultList.add(document);

			}

			ObjectMapper objectMapper = new ObjectMapper();
			String jsonResponse;
			try {
				jsonResponse = objectMapper.writeValueAsString(resultList);
			} catch (IOException e) {
				// Handle serialization error
				
				//throw new parserException("Error converting result to JSON")
				return ResponseEntity.status(500).body("Error converting result to JSON");
			}

			return ResponseEntity.ok().body(jsonResponse);
		} else {
			return ResponseEntity.ok().body(" Not an authroized UserId..Please try login ");
		}

	}

}
