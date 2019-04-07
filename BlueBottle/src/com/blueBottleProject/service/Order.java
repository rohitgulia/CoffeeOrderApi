package com.blueBottleProject.service;

import java.util.ArrayList;

import org.json.JSONObject;

import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.obj.OrderDetailsObj;

public interface Order {
	public ArrayList<OrderDetailsObj> getOrderList() throws Exception;
	public JSONObject updateOrder(OrderDetailsObj orderDtlsObj) throws OrderIdNotValidException, Exception;
	public JSONObject addNewOrder(OrderDetailsObj orderDtlsObj) throws OrderIdNotValidException, Exception;
}
