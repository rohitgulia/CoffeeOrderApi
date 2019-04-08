package com.blueBottleProject.repo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.junit.platform.commons.util.StringUtils;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.misc.OrderNotFoundException;
import com.blueBottleProject.obj.OrderDetailsObj;
import com.blueBottleProject.redis.RedisConnectionSetup;

public class OrderRepo implements OrderProcessor {

	RedisConnectionSetup redisConn;

	public OrderRepo(RedisConnectionSetup redisConn) {
		this.redisConn = redisConn;
	}

	public OrderRepo() {
	}

	public ArrayList<OrderDetailsObj> getOrderListRepo() throws Exception {
		RedissonClient redisClient = checkDatabaseConnection();
		RMap<Integer, OrderDetailsObj> orderListInRedis = redisClient.getMap("orderList");

		ArrayList<OrderDetailsObj> orderList = new ArrayList<OrderDetailsObj>();
		Iterator<Entry<Integer, OrderDetailsObj>> it = orderListInRedis.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, OrderDetailsObj> data = (Map.Entry<Integer, OrderDetailsObj>) it.next();
			orderList.add(new OrderDetailsObj(data.getValue()));
		}
		return orderList;
	}

	@Override
	public JSONObject updateOrderRepo(OrderDetailsObj orderDtlsObj) throws OrderIdNotValidException, Exception {
		RedissonClient redisClient = checkDatabaseConnection();
		RMap<Integer, OrderDetailsObj> orderListInRedis = redisClient.getMap("orderList");

		if (orderListInRedis.containsKey(orderDtlsObj.getOrderId())) {
			JSONObject result = new JSONObject();
			orderListInRedis.replace(orderDtlsObj.getOrderId(), orderDtlsObj);
			result.put("result", "success");
			return result;
		} else
			throw new OrderIdNotValidException("Sorry. Order not found!!");
	}

	@Override
	public JSONObject addNewOrderRepo(OrderDetailsObj orderDtlsObj) throws Exception {
		JSONObject result = new JSONObject();
		RedissonClient redisClient = checkDatabaseConnection();
		RMap<Integer, OrderDetailsObj> orderListInRedis = redisClient.getMap("orderList");
		RAtomicLong orderCounter = redisClient.getAtomicLong("orderCounter");

		if (orderCounter.isExists())
			orderCounter.set(orderCounter.incrementAndGet());
		else
			orderCounter.set(1);

		orderDtlsObj.setOrderId((int) orderCounter.get());
		// Add to redis
		orderListInRedis.put((int) orderCounter.get(), orderDtlsObj);
		result.put("result", new JSONObject(orderDtlsObj));
		return result;
	}

	private RedissonClient checkDatabaseConnection() throws Exception {
		if (redisConn == null)
			throw new Exception("Sorry. No Database connection");
		RedissonClient redisClient = redisConn.getRedisson();
		if (redisClient == null)
			throw new Exception("Sorry. No Database connection");
		return redisClient;
	}
}
