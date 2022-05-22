package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import br.com.foursys.fourcamp.fourstore.data.ProductDataInterface;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	private ProductDataInterface productInterfaceData;

    public ProductService(ProductDataInterface productInterfaceData) {
        this.productInterfaceData = productInterfaceData;
    }

    public String createProduct(Product product) throws InvalidSellValueException {
    	validateProfit(product);
        Product savedProduct = getProduct(product);
        return createMessageResponse(savedProduct.getSku(), " criado ");
    }

    public String updateBySku(String sku, Product product) throws ProductNotFoundException {
        verifyIfExists(sku);
        Product updatedProduct = getProduct(product);
        return createMessageResponse(updatedProduct.getSku(), " atualizado ");
    }

    public List<Product> listAll() {
        List<Product> allProducts = productInterfaceData.findAll();
        return allProducts;
    }

    public void deleteBySku(String sku) throws ProductNotFoundException {
        verifyIfExists(sku);
        productInterfaceData.deleteBySku(sku);
    }

    public String createMessageResponse(String sku, String s) {
        return s + "Produto com a Sku " + sku;
    }

    private Product verifyIfExists(String sku) throws ProductNotFoundException {
    	if (productInterfaceData.findBySku(sku).equals(null)) {
    		throw new ProductNotFoundException(sku);
    	} else {
    		return productInterfaceData.findBySku(sku);
    	}
    }
    
    private void validateProfit(Product product) throws InvalidSellValueException {
    	if ((product.getBuyPrice() * 1.25) > product.getSellPrice()) { 
    		throw new InvalidSellValueException();
    	}
    }

    private Product getProduct(Product product) {
        return productInterfaceData.save(product);
    }

    public Product findBySku(String sku) throws ProductNotFoundException {
        Product product = verifyIfExists(sku);
        return product;
    }
	
	
}
