package com.example.project_jdbc.dbtable;

public class Magazyn {
	
	private long id;
	
	private String name;
	
	private int amount;
	
	private int margin;

	public Magazyn(){
	}
	
	public Magazyn(String name, int amount, int margin){
		super();
		this.name = name;
		this.amount = amount;
		this.margin = margin;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}
	
}
