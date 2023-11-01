package com.walmart.orderhist.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.AggregateIterable;
import com.walmart.orderhist.dao.OrderHistDao;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.UserNotFoundException;

@Service
public class OrderHistServiceImpl implements OrderHistService {

	@Autowired
	private OrderHistDao orderHistDao;

	@Autowired
	private ObjectMapper objectMapper;

	private static final Logger log = LoggerFactory.getLogger(OrderHistServiceImpl.class);

	public boolean userCheck(Integer userId) {

		return orderHistDao.validUserCheck(userId);
	}

	public ResponseEntity<String> orderHist(Integer userId) throws UserNotFoundException, OrderNotFoundException {

		if (userCheck(userId)) {

			AggregateIterable<Document> result = orderHistDao.retrieveOrderAndItem(userId);

			List<Map<String, Object>> resultList = new ArrayList<>();

			for (Document document : result) {

				resultList.add(document);

			}

			if (resultList.isEmpty()) {
				throw new OrderNotFoundException("No order found for this user id.Please try to place the order ");
			}

			
			String jsonResponse;
			try {
				jsonResponse = objectMapper.writeValueAsString(resultList);

			} catch (IOException e) {
				// Handle serialization error

				// throw new parserException("Error converting result to JSON")
				return ResponseEntity.status(500).body("Error converting result to JSON");
			}

			return ResponseEntity.ok().body(jsonResponse);
			
		} else {

			log.info(" Not an authorized UserId..Please try login ");

			throw new UserNotFoundException(" Not an authorized UserId..Please try login ");
		}

	}

}
