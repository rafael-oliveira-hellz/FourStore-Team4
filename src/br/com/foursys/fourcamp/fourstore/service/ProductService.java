package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	
	
//	depende do Data para estabelecer a interface
	private ProductRepository ProductRepository;

    public ProductService(ProductRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    public String createProduct(Product Product) {
        Product savedProduct = getProduct(Product);
        return savedProduct.getSku() + " criado ";
    }

    public String updateBySku(String sku, Product Product) throws ProductNotFoundException {
        verifyIfExists(sku);
        Product updatedProduct = getProduct(Product);
        return updatedProduct.getSku() + " atualizado ";
    }

    public List<Product> listAll() {
        List<Product> allProducts = ProductRepository.findAll();
        return allProducts;
    }

    public void delete(String sku) throws ProductNotFoundException {
        verifyIfExists(sku);
        ProductRepository.deleteBySku(sku);
    }

    private String createMessageResponse(String sku, String s) {
        return s + "Produto com a Sku " + sku;
    }

    private Product verifyIfExists(String service) throws ProductNotFoundException {
        return ProductRepository.findBySku(service)
                .orElseThrow(() -> new ProductNotFoundException(sku));
    }

    private Product getProduct(Product Product) {
        return ProductRepository.save(Product);
    }

    public Product findBySku(String sku) throws ProductNotFoundException {
        Product Product = verifyIfExists(sku);
        return Product;
    }
	
	
}
