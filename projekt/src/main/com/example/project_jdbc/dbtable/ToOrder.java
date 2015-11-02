package com.example.project_jdbc.dbtable;

public class ToOrder {

	private long idOrder;
	
	private long idMagazyn;
	
	private int orderedAmount;
	
	private float price;
	
	public ToOrder() {
	}
	
	public ToOrder(long idMagazyn, int orderedAmount, float price){
		super();
		this.idMagazyn = idMagazyn;
		this.orderedAmount = orderedAmount;
		this.price = price;
	}
	
	public long getId() {
		return idOrder;
	}

	public void setId(long idOrder) {
		this.idOrder = idOrder;
	}

	public long getMagazynId() {
		return idMagazyn;
	}

	public void setMagazynId(long idMagazyn) {
		this.idMagazyn = idMagazyn;
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
