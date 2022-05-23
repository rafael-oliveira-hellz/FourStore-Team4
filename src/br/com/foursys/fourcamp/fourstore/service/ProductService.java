package br.com.foursys.fourcamp.fourstore.service;

import java.util.HashMap;
import br.com.foursys.fourcamp.fourstore.data.ProductDataInterface;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	private ProductDataInterface productDataInterface;

    public ProductService(ProductDataInterface productDataInterface) {
        this.productDataInterface = productDataInterface;
    }

    public String createProduct(Product product, Integer quantity) throws InvalidSellValueException {
    	validateProfit(product);
        String savedProduct = getProduct(product, quantity);
        return "Adicionadas " + savedProduct;
    }

    public String updateBySku(String sku, Integer quantity) throws ProductNotFoundException {
        Product product = verifyIfExists(sku);
        String updatedProduct = getProduct(product, quantity);
        return "Adicionadas " + updatedProduct;
    }

    public HashMap<Product, Integer> listAll() {
        HashMap<Product, Integer> allProducts = productDataInterface.findAll();
        return allProducts;
    }

    public void deleteBySku(String sku) throws ProductNotFoundException {
        verifyIfExists(sku);
        productDataInterface.deleteBySku(sku);
    }

    public String createMessageResponse(String sku, String s) {
        return s + "Produto com a Sku " + sku;
    }

    private Product verifyIfExists(String sku) throws ProductNotFoundException {
    	if (productDataInterface.findBySku(sku).equals(null)) {
    		throw new ProductNotFoundException(sku);
    	} else {
    		return productDataInterface.findBySku(sku);
    	}
    }
    
    private void validateProfit(Product product) throws InvalidSellValueException {
    	if ((product.getBuyPrice() * 1.25) > product.getSellPrice()) { 
    		throw new InvalidSellValueException();
    	}
    }

    private String getProduct(Product product, Integer quantity) {
        return productDataInterface.save(product, quantity);
    }

    public Product findBySku(String sku) throws ProductNotFoundException {
        Product product = verifyIfExists(sku);
        return product;
    }
	
	
}
