package univpm.it.CastelDeSa.progettoOOP.exceptions;

/**
 * classe di eccezione relativa al codice di risposta "400, bad request" di httpRequest 
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class badReqException extends Exception{

	/**
	 * classe costruttore
	 */
	public badReqException() {
		super();
		System.out.println("RICHIESTA NON VALIDA");

	}


}