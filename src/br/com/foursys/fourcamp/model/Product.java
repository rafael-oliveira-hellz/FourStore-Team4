package br.com.foursys.fourcamp.model;

public class Product {
	String sku;
	Double buyPrice;
	Double sellPrice;
	Integer quantity;
	String type;
	String size;
	String color;
	String category;
	String department;
	String description;
	
	public Product(String sku, Integer quantity) {
		super();
		this.sku = sku;
		this.quantity = quantity;
	}
	
	public Product(String sku, Double buyPrice, Double sellPrice, Integer quantity, String type, String size, String color, String category,
			String department, String description) {
		super();
		this.sku = sku;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.quantity = quantity;
		this.type = type;
		this.size = size;
		this.color = color;
		this.category = category;
		this.department = department;
		this.description = description;
	}
	
	public Double getbuyPrice() {
		return buyPrice;
	}
	
	public void setbuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	public Double getsellPrice() {
		return sellPrice;
	}
	
	public void setsellPrice(Double sellPrice) {
		this.buyPrice = sellPrice;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSku() {
		return sku;
	}
}
