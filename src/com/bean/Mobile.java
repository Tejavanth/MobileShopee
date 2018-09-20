package com.bean;

import java.io.Serializable;

public class Mobile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1719805936100344466L;
	private int id;
	private double cost;
	private TypeOfDisplay TypeOfDisplay;
	private Style Style;
	private Brand Brand;
	private int quantity;
	private OperatingSystems OperatingSystems;
	
	public Mobile(int id, double cost, OperatingSystems OperatingSystems, Brand brand, Style style, TypeOfDisplay typeOfDisplay,  
			int quantity) {
		super();
		this.id = id;
		this.cost = cost;
		this.OperatingSystems = OperatingSystems;
		this.TypeOfDisplay = typeOfDisplay;
		this.Style = style;
		this.Brand = brand;
		this.quantity = quantity;
	}
	
	
	public OperatingSystems getOperatingSystems() {
		return OperatingSystems;
	}
	public void setOperatingSystems(OperatingSystems operatingSystems) {
		OperatingSystems = operatingSystems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public TypeOfDisplay getTypeOfDisplay() {
		return TypeOfDisplay;
	}
	public void setTypeOfDisplay(TypeOfDisplay typeOfDisplay) {
		TypeOfDisplay = typeOfDisplay;
	}
	public Style getStyle() {
		return Style;
	}
	public void setStyle(Style style) {
		Style = style;
	}
	public Brand getBrand() {
		return Brand;
	}
	public void setBrand(Brand brand) {
		Brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
