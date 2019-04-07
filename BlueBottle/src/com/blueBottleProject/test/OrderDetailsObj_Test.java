package com.blueBottleProject.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;
import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.obj.OrderDetailsObj;

public class OrderDetailsObj_Test {
	
	 @Rule
	    public ExpectedException expectdException = ExpectedException.none();
	
    @Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void orderDetailsObj_allValuesPassedCorrectly_objectHasAllValuesSet() throws OrderIdNotValidException, Exception {
    	OrderDetailsObj orderDtls = new OrderDetailsObj(1, "Bella Donovan", "Cold Brew", "2019-12-10", 2,
				50, "test note", false);
    	assertTrue(orderDtls.getOrderId() == 1);
    	assertTrue(orderDtls.getCoffeeName().equalsIgnoreCase("Bella Donovan"));
    	assertTrue(orderDtls.getBrewMethod().equalsIgnoreCase("Cold Brew"));
    	assertTrue(orderDtls.getShipDate().equalsIgnoreCase("2019-12-10"));
    	assertTrue(orderDtls.getNumberOfCases() == 2);
    	assertTrue(orderDtls.getPacketsPerCase() == 50);
    	assertTrue(orderDtls.getNotes().equalsIgnoreCase("test note"));
    	assertTrue(orderDtls.isPriority() == false);
    }
    
    
    
    @Test
    public void orderDetailsObj_emptyCoffeeName_throwsException() throws Exception {
    	expectdException.expect(Exception.class);
    	expectdException.expectMessage("Sorry. Order not valid!!");
    	new OrderDetailsObj(0, "", "Cold Brew", "2019-12-10", 2,
				50, "test note", false);
    }
    
    @Test
    public void orderDetailsObj_emptyMethodName_throwsException() throws Exception {
    	expectdException.expect(Exception.class);
    	expectdException.expectMessage("Sorry. Order not valid!!");
    	new OrderDetailsObj(0, "Bella Donovan", "", "2019-12-10", 2,
				50, "test note", false);
    }
    
    @Test
    public void orderDetailsObj_emptyDate_throwsException() throws Exception {
    	expectdException.expect(Exception.class);
    	expectdException.expectMessage("Sorry. Order not valid!!");
    	new OrderDetailsObj(0, "Bella Donovan", "Cold Brew", "", 2,
				50, "test note", false);
    }
    
    @Test
    public void orderDetailsObj_negativeNumberOfCases_throwsException() throws Exception {
    	expectdException.expect(Exception.class);
    	expectdException.expectMessage("Sorry. Order not valid!!");
    	new OrderDetailsObj(0, "Bella Donovan", "Cold Brew", "2019-12-10", -2,
				50, "test note", false);
    }
    
    @Test
    public void orderDetailsObj_negativePacketsPerCase_throwsException() throws Exception {
    	expectdException.expect(Exception.class);
    	expectdException.expectMessage("Sorry. Order not valid!!");
    	new OrderDetailsObj(0, "Bella Donovan", "Cold Brew", "2019-12-10", 2,
				-50, "test note", false);
    }
}
