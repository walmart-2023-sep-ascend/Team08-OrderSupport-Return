package com.walmart.orderhist;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.walmart.orderhist.service.OrderReturnServiceImpl;
import com.walmart.orderhist.rest.ReturnAPI;
import com.walmart.orderhist.exception.ExternalReturnNotRunningException;

@RunWith(SpringRunner.class)
@SpringBootTest
class Team08OrderHistoryTrackerApplicationTests {
	
	@Autowired
	private OrderReturnServiceImpl returnService;
	
	@MockBean
	private ReturnAPI returnAPI;

	@Test
	void getReturnInfo_ShouldThrowExceptionWhenNoResponse() throws Exception {
		String testEmailId = "testUserId";
		String testOrderId = "909090";
		when(returnAPI.getReturnDetails(testOrderId,testEmailId)).thenReturn(null);
		assertThrows(ExternalReturnNotRunningException.class, () -> returnService.orderReturn(testOrderId,testEmailId));
	}
}
