package br.com.foursys.fourcamp.fourstore.utils;

public class RunTime {

	public static void ThreadDelay() {
		try {
			Thread.sleep(1L);
		} catch (InterruptedException e) {
			System.out.println("Nunca vai cair aqui");
		}
	}
	
}
