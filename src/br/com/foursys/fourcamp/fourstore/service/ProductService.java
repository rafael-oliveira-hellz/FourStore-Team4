package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;
import br.com.foursys.fourcamp.fourstore.data.ProductInterfaceData;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	
	
//	depende do Data para estabelecer a interface
	private ProductInterfaceData ProductInterfaceData;

    public ProductService(ProductInterfaceData ProductInterfaceData) {
        this.ProductInterfaceData = ProductInterfaceData;
    }

    public String createProduct(Product Product) {
        Product savedProduct = getProduct(Product);
        return createMessageResponse(savedProduct.getSku(), " criado ");
    }

    public String updateBySku(String sku, Product Product) throws ProductNotFoundException {
        verifyIfExists(sku);
        Product updatedProduct = getProduct(Product);
        return createMessageResponse(updatedProduct.getSku(), " atualizado ");
    }

    public List<Product> listAll() {
        List<Product> allProducts = ProductInterfaceData.findAll();
        return allProducts;
    }

    public void deleteBySku(String sku) throws ProductNotFoundException {
        verifyIfExists(sku);
        ProductInterfaceData.deleteBySku(sku);
    }

    private String createMessageResponse(String sku, String s) {
        return s + "Produto com a Sku " + sku;
    }

    private Product verifyIfExists(String sku) throws ProductNotFoundException {
    	if (ProductInterfaceData.findBySku(sku).equals(null)) {
    		throw new ProductNotFoundException(sku);
    	} else {
    		return ProductInterfaceData.findBySku(sku);
    	}
    }

    private Product getProduct(Product Product) {
        return ProductInterfaceData.save(Product);
    }

    public Product findBySku(String sku) throws ProductNotFoundException {
        Product Product = verifyIfExists(sku);
        return Product;
    }
	
	
}
