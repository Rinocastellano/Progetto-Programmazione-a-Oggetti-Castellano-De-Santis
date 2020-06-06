
package univpm.it.CastelDeSa.progettoOOP.exceptions;
/**
 * classe di eccezione relativa al codice di risposta "404" per l'httpRequest
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class notFoundMethodException extends Exception {
	/**
	 * costruttore
	 */
	public notFoundMethodException() {
		super();
		System.out.println("METODO NON TROVATO");
	}

}