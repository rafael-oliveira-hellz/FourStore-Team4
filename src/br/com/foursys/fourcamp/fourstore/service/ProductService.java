package br.com.foursys.fourcamp.fourstore.service;

import java.util.List;

import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {

	/*
	
//	depende do Data para estabelecer a interface
	private ProductRepository ProductRepository;

    public ProductService(ProductRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

//	Sem DTO não tenho certeza de quem MessageResponse é responsabilidade
    public MessageResponse createProduct(Product Product) {
        Product savedProduct = getProduct(Product);
        return createMessageResponse(savedProduct.getId(), "Criado ");
    }

    public MessageResponse updateById(Long id, Product Product) throws ProductNotFoundException {
        verifyIfExists(id);
        Product updatedProduct = getProduct(Product);
        return createMessageResponse(updatedProduct.getId(), "Atualizado ");
    }

    public List<Product> listAll() {
        List<Product> allProducts = ProductRepository.findAll();
        return allProducts;
    }

    public void delete(Long id) throws ProductNotFoundException {
        verifyIfExists(id);
        ProductRepository.deleteById(id);
    }

    private MessageResponse createMessageResponse(Long id, String s) {
        return MessageResponse.builder()
                .message(s + "Produto com a ID " + id)
                .build();
    }

//	Depende da lista presente no Data retornando os produtos de acordo com a respectiva id
    private Product verifyIfExists(Long id) throws ProductNotFoundException {
        return ProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    private Product getProduct(Product Product) {
        return ProductRepository.save(Product);
    }

    public Product findById(Long id) throws ProductNotFoundException {
        Product Product = verifyIfExists(id);
        return Product;
    }
	
	*/
}
