package com.blueBottleProject.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

import com.blueBottleProject.client.Consumer_Test;
import com.blueBottleProject.misc.OrderIdNotValidException;


public class ProductDetails_Test {
    
	private Consumer_Test consumerTest;
	
    @Rule
    public ExpectedException expectdException = ExpectedException.none();
    
    @Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		consumerTest = new Consumer_Test();
    }
    
    @Test
    public void addNewProductToRedis_negativeProductId_throwsProductIdNotValidException() throws OrderIdNotValidException, Exception {
    	expectdException.expect(OrderIdNotValidException.class);
    	expectdException.expectMessage("Sorry. Product id not valid");
    	consumerTest.createNewData_invalidProductId_throwException();
    }
    
    @Test
    public void addNewProductToRedis_negativePrice_throwsException() throws OrderIdNotValidException, Exception {
    	expectdException.expect(Exception.class);
    	expectdException.expectMessage("Sorry. Price cannot be negative");
    	consumerTest.createNewData_invalidPriceValue_throwException();
    }
    
    @Test
    public void updateProductPrice_negativeProductIdInResponseBody_throwsProductIdNotValidException() throws OrderIdNotValidException, Exception {
    	expectdException.expect(OrderIdNotValidException.class);
    	expectdException.expectMessage("Sorry. Product id not valid");
    	consumerTest.updateData_invalidProductId_throwException();
    }
    
    @Test
    public void updateProductPrice_negativePrice_throwsException() throws OrderIdNotValidException, Exception {
    	expectdException.expect(Exception.class);
    	expectdException.expectMessage("Sorry. Price cannot be negative");
    	consumerTest.updateData_invalidPriceValue_throwException();
    }
}
