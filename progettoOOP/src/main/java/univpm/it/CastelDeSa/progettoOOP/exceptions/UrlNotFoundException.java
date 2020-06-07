
package univpm.it.CastelDeSa.progettoOOP.exceptions;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
/**
 * classe di eccezione per URL non trovat
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class UrlNotFoundException extends Exception {
	/**
	 * costruttore
	 * @param e , eccezione di tipo UknownHost
	 */
	public UrlNotFoundException ( UnknownHostException e) {
		super();
		System.out.println("URL NON TROVATO");
	}
}