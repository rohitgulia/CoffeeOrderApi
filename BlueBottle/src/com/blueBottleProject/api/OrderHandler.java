package com.blueBottleProject.api;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.obj.OrderDetailsObj;
import com.blueBottleProject.redis.RedisConnectionSetup;
import com.blueBottleProject.service.Order;
import com.blueBottleProject.service.OrderService;

//http://localhost:8080/BlueBottle/api/orders
@Path("/orders")
public class OrderHandler {

	private Order order;

	@Inject
	RedisConnectionSetup redisConn;

	// http://localhost:8080/BlueBottle/api/orders/orderList
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/orderList")
	public Response getOrderList() {
		try {
			order = new OrderService(redisConn);
			ArrayList<OrderDetailsObj> orderDtlsObjList = order.getOrderList();
			GenericEntity<ArrayList<OrderDetailsObj>> orderList= new GenericEntity<ArrayList<OrderDetailsObj>>(orderDtlsObjList) {};
			return Response.status(200).entity(orderList).build();
		} catch (Exception e) {
			JSONObject result = new JSONObject();
			result.put("error", e.getMessage());
			return Response.status(204).entity(result.toString()).build(); // 204: no content http status
		}
	}

	// modify existing data in redis
	// http://localhost:8080/BlueBottle/api/orders/updateOrder
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateOrder")
	public Response updateOrder(OrderDetailsObj orderDtlsObj) {
		JSONObject result = new JSONObject();
		try {
			order = new OrderService(redisConn);
			result = order.updateOrder(orderDtlsObj);
			return Response.status(200).entity(result.toString()).build();
		} catch (OrderIdNotValidException e) {
			result.put("error", e.getMessage());
			return Response.status(409).entity(result.toString()).build(); // 409: conflict status
		} catch (Exception e) {
			result.put("error", e.getMessage());
			return Response.status(204).entity(result.toString()).build();
		}
	}

	// add new data to redis
	// http://localhost:8080/BlueBottle/api/orders/addOrder
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addOrder")
	public Response addNewProductToRedis(OrderDetailsObj orderDtlsObj) {
		JSONObject result = new JSONObject();
		try {
			order = new OrderService(redisConn);
			result = order.addNewOrder(orderDtlsObj);
			return Response.status(201).entity(result.toString()).build(); // 201: Http created status
		} catch (OrderIdNotValidException e) {
			result.put("error", e.getMessage());
			return Response.status(409).entity(result.toString()).build();
		} catch (Exception e) {
			result.put("error", e.getMessage());
			return Response.status(409).entity(result.toString()).build();
		}
	}

}