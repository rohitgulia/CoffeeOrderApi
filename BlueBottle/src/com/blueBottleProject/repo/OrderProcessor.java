package com.blueBottleProject.repo;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.obj.OrderDetailsObj;

public interface OrderProcessor {
	public ArrayList<OrderDetailsObj> getOrderListRepo() throws Exception;
	public JSONObject updateOrderRepo(OrderDetailsObj orderDtlsObj) throws OrderIdNotValidException, Exception;
	public JSONObject addNewOrderRepo(OrderDetailsObj orderDtlsObj) throws OrderIdNotValidException, Exception;
}
