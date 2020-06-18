package com.cognizant.truyum.model;

import java.util.List;

public class Cart {

	private double total;
	private List<MenuItem> menuItem_List;
	
	public Cart() {
		super();
	}

	public Cart(double total, List<MenuItem> menuItem_List) {
		super();
		this.total = total;
		this.menuItem_List = menuItem_List;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<MenuItem> getMenuItem_List() {
		return menuItem_List;
	}

	public void setMenuItem_List(List<MenuItem> menuItem_List) {
		this.menuItem_List = menuItem_List;
	}

	@Override
	public String toString() {
		return "Cart [total=" + total + ", menuItem_List=" + menuItem_List + "]";
	}
	
}
