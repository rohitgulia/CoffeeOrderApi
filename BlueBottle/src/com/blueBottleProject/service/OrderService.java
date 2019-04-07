package com.blueBottleProject.service;

import java.util.ArrayList;
import org.json.JSONObject;
import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.obj.OrderDetailsObj;
import com.blueBottleProject.redis.RedisConnectionSetup;
import com.blueBottleProject.repo.OrderProcessor;
import com.blueBottleProject.repo.OrderRepo;

public class OrderService implements Order {
	OrderProcessor orderDtlsRepo;
	public OrderService(RedisConnectionSetup redisConn) {
		orderDtlsRepo = new OrderRepo(redisConn);
	}
	
	public OrderService() {}

	@Override
	public ArrayList<OrderDetailsObj> getOrderList() throws Exception{
		return orderDtlsRepo.getOrderListRepo();
	}

	@Override
	public JSONObject updateOrder(OrderDetailsObj orderDtlsObj) throws OrderIdNotValidException, Exception {
		return orderDtlsRepo.updateOrderRepo(orderDtlsObj);
	}

	@Override
	public JSONObject addNewOrder(OrderDetailsObj orderDtlsObj) throws Exception {
		return orderDtlsRepo.addNewOrderRepo(orderDtlsObj);
	}
	
}