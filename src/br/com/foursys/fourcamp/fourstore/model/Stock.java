package br.com.foursys.fourcamp.fourstore.model;

public class Stock {
	
	private Product product;
	private Integer quantity;
	
	public Stock(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stock stock = (Stock) o;
		return product.equals(stock.product);
	}

	@Override
	public String toString() {
		return "Stock [Produto: " + product.toString() + ", quantidade: " + quantity + "]";
	}
}

