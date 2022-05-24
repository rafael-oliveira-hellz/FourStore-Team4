package br.com.foursys.fourcamp.fourstore.model;

import br.com.foursys.fourcamp.fourstore.enums.CategoryEnum;
import br.com.foursys.fourcamp.fourstore.enums.ColorEnum;
import br.com.foursys.fourcamp.fourstore.enums.DepartmentEnum;
import br.com.foursys.fourcamp.fourstore.enums.SizeEnum;
import br.com.foursys.fourcamp.fourstore.enums.TypeOfMerchandiseEnum;

public class Product {
	private String sku;
	private String brand;
	private String type;
	private String size;
	private String color;
	private String category;
	private String department;
	private Double buyPrice;
	private Double  sellPrice;
	private String description;
	
	
	public Product (String sku, String description, double buyPrice, double sellPrice) {
		this.description = description;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		parseSku(sku);
	}
	
	private void parseSku(String sku) {
		this.brand = sku.substring(0, 3);
		this.size = SizeEnum.get(sku.substring(3, 5)).getDescription();
		this.category = CategoryEnum.get(sku.substring(5, 7)).getDescription();
		this.type = TypeOfMerchandiseEnum.get(sku.substring(7, 9)).getDescription();
		this.department = DepartmentEnum.get(sku.substring(9, 11)).getDescription();
		this.color = ColorEnum.get(sku.substring(11, 13)).getDescription();
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public String getSku() {
		return sku;
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", type=" + type + ", size=" + size + ", color=" + color + ", category="
				+ category + ", department=" + department + ", Price=" + sellPrice + ", description=" + description
				+ "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
		return sku.equals(product.sku);
	}
}