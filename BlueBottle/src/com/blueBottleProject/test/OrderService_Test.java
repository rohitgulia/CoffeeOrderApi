package com.blueBottleProject.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;
import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.obj.OrderDetailsObj;
import com.blueBottleProject.service.OrderService;

public class OrderService_Test {
	
	OrderService orderService;
	
	 @Rule
	    public ExpectedException expectdException = ExpectedException.none();
	 
	 @Before
		public void setup() {
			MockitoAnnotations.initMocks(this);
			orderService = new OrderService();
	    }

	@Test
    public void updateOrder_nullOrderId_throwsException() throws OrderIdNotValidException, Exception {
    	expectdException.expect(OrderIdNotValidException.class);
    	expectdException.expectMessage("Sorry. Order id not valid");
    	OrderDetailsObj orderDtls = new OrderDetailsObj(null, "Bella Donovan", "Cold Brew", "2019-12-10", 2,
				50, "test note", false); 
    	orderService.updateOrder(orderDtls);
    }
    
    @Test
    public void updateOrder_negativeOrderId_throwsException() throws OrderIdNotValidException, Exception {
    	expectdException.expect(OrderIdNotValidException.class);
    	expectdException.expectMessage("Sorry. Order id not valid");
    	OrderDetailsObj orderDtls = new OrderDetailsObj(-1, "Bella Donovan", "Cold Brew", "2019-12-10", 2,
				50, "test note", false);
    	orderService.updateOrder(orderDtls);
    }
	
}
