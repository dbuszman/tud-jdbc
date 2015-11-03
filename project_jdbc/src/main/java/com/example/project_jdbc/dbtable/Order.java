package com.example.project_jdbc.dbtable;

public class Order {

	private long id;
	
	private long magazynId;
	
	private int orderedAmount;
	
	private float price;
	
	public Order() {
	}
	
	public Order(long magazynId, int orderedAmount, float price){
		super();
		this.magazynId = magazynId;
		this.orderedAmount = orderedAmount;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMagazynId() {
		return magazynId;
	}

	public void setMagazynId(long magazynId) {
		this.magazynId = magazynId;
	}

	public int getOrderedAmount() {
		return orderedAmount;
	}

	public void setOrderedAmount(int orderedAmount) {
		this.orderedAmount = orderedAmount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	

}
