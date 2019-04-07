package com.blueBottleProject.obj;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.blueBottleProject.misc.OrderIdNotValidException;

@XmlRootElement
public class OrderDetailsObj implements java.io.Serializable{

	private static final long serialVersionUID = 1996030128960812951L;
	
	private Integer orderId;
	private String coffeeName;
	private String brewMethod;
	private String shipDate;
	private Integer numberOfCases;
	private Integer packetsPerCase;
	private String notes;
	private boolean priority;
	
	public OrderDetailsObj(OrderDetailsObj orderDetails) throws OrderIdNotValidException {
		if(orderDetails.getOrderId() < 0)
			throw new OrderIdNotValidException("Sorry. Order id not valid");
		this.orderId = orderDetails.getOrderId();
		this.coffeeName = orderDetails.getCoffeeName();
		this.brewMethod = orderDetails.getBrewMethod();
		this.shipDate = orderDetails.getShipDate();
		this.numberOfCases = orderDetails.getNumberOfCases();
		this.packetsPerCase = orderDetails.getPacketsPerCase();
		this.notes = orderDetails.getNotes();
		this.priority = orderDetails.isPriority();
	}
	
//	public OrderDetailsObj(int orderId, String coffeeName, String brewMethod, Date shipDate, int numberOfCases, int packetsPerCase, String notes, boolean priority) throws OrderIdNotValidException {
//		if(orderId < 0)
//			throw new OrderIdNotValidException("Sorry. Order id not valid");
//		this.orderId = orderId;
//		this.coffeeName = coffeeName;
//		this.brewMethod = brewMethod;
//		this.shipDate = shipDate;
//		this.numberOfCases = numberOfCases;
//		this.packetsPerCase = packetsPerCase;
//		this.notes = notes;
//		this.priority = priority;
//	}
	
	public OrderDetailsObj(Integer id) throws OrderIdNotValidException{
		if(id < 0)
			throw new OrderIdNotValidException("Sorry. Order id not valid");
	}
	
	public OrderDetailsObj() {}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public String getBrewMethod() {
		return brewMethod;
	}

	public void setBrewMethod(String brewMethod) {
		this.brewMethod = brewMethod;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public Integer getNumberOfCases() {
		return numberOfCases;
	}

	public void setNumberOfCases(Integer numberOfCases) {
		this.numberOfCases = numberOfCases;
	}

	public Integer getPacketsPerCase() {
		return packetsPerCase;
	}

	public void setPacketsPerCase(Integer packetsPerCase) {
		this.packetsPerCase = packetsPerCase;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}
}