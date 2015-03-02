package org.xm.demofromweb;

public class OrderEvent {

	private double price;

	private String itemName;

	public OrderEvent(double price, String itemName) {
		super();
		this.price = price;
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public String getItemName() {
		return itemName;
	}

}
