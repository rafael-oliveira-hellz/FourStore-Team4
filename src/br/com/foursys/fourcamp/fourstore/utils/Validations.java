package br.com.foursys.fourcamp.fourstore.utils;

public class Validations {

	public int validationMenu(String entry, String verifyMenu) {
		int option;
		
		if(entry.matches(verifyMenu)) {
			option = Integer.parseInt(entry);
			return option;
		} else {
			option = -1;
			return option;
		}
	}
}
