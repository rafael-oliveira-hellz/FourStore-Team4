package br.com.foursys.fourcamp.fourstore.service;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Long id) {
        super("Nenhum produto encontrado com a id " + id);
    }
}
