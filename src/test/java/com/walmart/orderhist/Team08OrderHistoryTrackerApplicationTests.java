package com.walmart.orderhist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import com.walmart.orderhist.dao.OrderHistDao;
import com.walmart.orderhist.exception.OrderNotFoundException;
import com.walmart.orderhist.exception.UserNotFoundException;
import com.walmart.orderhist.service.OrderHistService;
import com.walmart.orderhist.service.OrderHistServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class Team08OrderHistoryTrackerApplicationTests {

	@MockBean
	private OrderHistDao orderHistDao;

	@Autowired
	private OrderHistServiceImpl orderHistService;

	@Test
     void testOrderHist_UserNotFound()   {
        // Mock the behavior of userCheck to simulate a user not found
        when(orderHistDao.validUserCheck(anyInt())).thenReturn(false);

        try {
            // Perform the method invocation
            orderHistService.orderHist(123); // Passing a user ID
            
            // If no exception is thrown, fail the test
            fail("Expected UserNotFoundException but no exception was thrown");
        } catch (UserNotFoundException exception) {
            assertEquals(" Not an authorized UserId..Please try login ", exception.getMessage());
        } catch (OrderNotFoundException exception) {
			
		
		}
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

        try {
            // Perform the method invocation
            orderHistService.orderHist(456); // Passing a user ID

            // If no exception is thrown, fail the test
            fail("Expected OrderNotFoundException but no exception was thrown");
        } catch (OrderNotFoundException exception) {
            assertEquals("No order found for this user id.Please try to place the order ", exception.getMessage());
        } catch (UserNotFoundException e) {
			
		}      
        
    }

}
