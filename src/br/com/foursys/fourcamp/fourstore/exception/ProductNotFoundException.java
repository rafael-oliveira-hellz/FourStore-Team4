package br.com.foursys.fourcamp.fourstore.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String sku) {
        super("Nenhum produto encontrado com a Sku " + sku);
    }
}
