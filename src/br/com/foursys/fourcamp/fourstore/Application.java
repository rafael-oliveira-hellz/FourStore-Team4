/**
 * 
 */
package br.com.foursys.fourcamp.fourstore;

import br.com.foursys.fourcamp.fourstore.communication.MainMenu;

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
	 */
	public static void main(String[] args) {

		MainMenu menu = new MainMenu();

		menu.login();
	}

}
