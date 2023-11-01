package com.walmart.orderhist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import com.walmart.orderhist.dao.OrderHistDao;
import com.walmart.orderhist.dao.OrderHistDaoImpl;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.UserNotFoundException;
import com.walmart.orderhist.service.OrderHistService;
import com.walmart.orderhist.service.OrderHistServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class Team08OrderHistoryTrackerApplicationTests {

	@MockBean
	private OrderHistDaoImpl orderHistDao;

	@InjectMocks
	private OrderHistServiceImpl orderHistService;

	

	@Test
     void testOrderHist_UserNotFound() {
        // Mock the behavior of userCheck to simulate a user not found
        when(orderHistDao.validUserCheck(anyInt())).thenReturn(false);

        // Perform the method invocation
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
        	orderHistService.orderHist(123); // Passing a user ID
        });
        
        System.out.println(exception.getMessage());

        assertEquals(" Not an authorized UserId..Please try login ", exception.getMessage());
    }

	@Test
     void testOrderHist_OrderNotFound() {
        // Mock the behavior of userCheck to simulate an authorized user
        when(orderHistDao.validUserCheck(anyInt())).thenReturn(true);
        
        AggregateIterable<Document> mockResult = mock(AggregateIterable.class);
        when(orderHistDao.retrieveOrderAndItem(anyInt())).thenReturn(mockResult);

        MongoCursor<Document> mockCursor = mock(MongoCursor.class);
        when(mockCursor.hasNext()).thenReturn(false); // Simulate an empty result set
        when(mockResult.iterator()).thenReturn(mockCursor);

         // Perform the method invocation
        OrderNotFoundException exception = assertThrows(OrderNotFoundException.class, () -> {
            orderHistService.orderHist(456); // Passing a user ID
        });

        assertEquals("No order found for this user id.Please try to place the order ", exception.getMessage());
    }

}
