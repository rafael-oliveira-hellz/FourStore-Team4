package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.utils.Validations;

public class MenuController {

	public int validationRegexMenu(String entry, String verifyMenu) {
		
		Validations validations = new Validations();
		return validations.validationMenu(entry, verifyMenu);
	}
}
