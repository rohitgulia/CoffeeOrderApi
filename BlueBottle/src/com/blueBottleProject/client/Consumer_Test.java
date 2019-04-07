package com.blueBottleProject.client;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blueBottleProject.misc.OrderIdNotValidException;
import com.blueBottleProject.obj.OrderDetailsObj;

public class Consumer_Test {

	private static final String URL = "http://localhost:8080/BlueBottle/api/orders";

	private Client client = ClientBuilder.newClient();

	public void updateOrder_invalidOrderId_throwException() throws OrderIdNotValidException, Exception {
		OrderDetailsObj orderDtlsObj = new OrderDetailsObj(1, "Bella Donovan", "Cold Brew", "2019-12-10", 2,
				50, "test note", false);
		client.target(URL).path(String.valueOf("updateOrder")).request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(orderDtlsObj, MediaType.APPLICATION_JSON));
	}
//	public void addNewOrder_emptyCoffeName_throwException() throws Exception {
//		OrderDetailsObj orderDtlsObj = new OrderDetailsObj(0, "", "Cold Brew", "2019-12-10", 2,
//				50, "test note", false);
//		client.target(URL).path(String.valueOf("addOrder")).request(MediaType.APPLICATION_JSON)
//				.post(Entity.entity(orderDtlsObj, MediaType.APPLICATION_JSON));
//	}
//	public void addNewOrder_emptyMethodName_throwException() throws Exception {
//		OrderDetailsObj orderDtlsObj = new OrderDetailsObj(0, "Bella Donovan", "", "2019-12-10", 2,
//				50, "test note", false);
//		client.target(URL).path(String.valueOf("addOrder")).request(MediaType.APPLICATION_JSON)
//				.post(Entity.entity(orderDtlsObj, MediaType.APPLICATION_JSON));
//	}
//	public void addNewOrder_emptyDate_throwException() throws Exception {
//		OrderDetailsObj orderDtlsObj = new OrderDetailsObj(0, "Bella Donovan", "Cold Brew", "", 2,
//				50, "test note", false);
//		client.target(URL).path(String.valueOf("addOrder")).request(MediaType.APPLICATION_JSON)
//				.post(Entity.entity(orderDtlsObj, MediaType.APPLICATION_JSON));
//	}
//	public void addNewOrder_invalidNumberOfCases_throwException() throws Exception {
//		OrderDetailsObj orderDtlsObj = new OrderDetailsObj(0, "Bella Donovan", "Cold Brew", "2019-12-10", -2,
//				50, "test note", false);
//		client.target(URL).path(String.valueOf("addOrder")).request(MediaType.APPLICATION_JSON)
//				.post(Entity.entity(orderDtlsObj, MediaType.APPLICATION_JSON));
//	}
//	public void addNewOrder_invalidPacketsPerCase_throwException() throws Exception {
//		OrderDetailsObj orderDtlsObj = new OrderDetailsObj(0, "Bella Donovan", "Cold Brew", "2019-12-10", 2,
//				-50, "test note", false);
//		client.target(URL).path(String.valueOf("addOrder")).request(MediaType.APPLICATION_JSON)
//				.post(Entity.entity(orderDtlsObj, MediaType.APPLICATION_JSON));
//	}
}
