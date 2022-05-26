package br.com.foursys.fourcamp.fourstore.utils;



public class ValidationRegex {
	
	
	public Boolean regexValidation(String input, String regex) {
		if(input.matches(regex)) {
			return true;
		}
			return false;
	}
}
