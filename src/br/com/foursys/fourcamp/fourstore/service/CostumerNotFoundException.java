package br.com.foursys.fourcamp.fourstore.service;

public class CostumerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CostumerNotFoundException(Long id) {
        super("Nenhum cliente encontrado com o cpf " + id);
    }
	
}
