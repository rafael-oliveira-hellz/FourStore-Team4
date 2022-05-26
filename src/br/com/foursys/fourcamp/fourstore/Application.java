/**
 * 
 */
package br.com.foursys.fourcamp.fourstore;

import br.com.foursys.fourcamp.fourstore.communication.MainMenu;
import br.com.foursys.fourcamp.fourstore.exception.InvalidSellValueException;
import br.com.foursys.fourcamp.fourstore.exception.ProductNotFoundException;

/**
 * @author Rafael de Oliveira
 * @author Michael Rafael
 * @author Robson
 * @author Thales
 * @author Vanessa
 * @author Vinícius Jesus
 * @author Vinícius Santos
 * @author Pedro Augusto
 */
public class Application {

	/**
	 * @param args
	 * @throws ProductNotFoundException 
	 * @throws InvalidSellValueException 
	 */
	public static void main(String[] args) throws InvalidSellValueException, ProductNotFoundException {

		MainMenu menu = new MainMenu();

		menu.login();
	}

}
