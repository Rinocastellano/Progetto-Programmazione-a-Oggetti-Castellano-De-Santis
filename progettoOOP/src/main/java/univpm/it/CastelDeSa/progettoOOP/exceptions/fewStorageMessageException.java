package univpm.it.CastelDeSa.progettoOOP.exceptions;
/**
 * classe di eccezione per basso numero di message per post temporizzato randomico
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class fewStorageMessageException extends Exception {
	/**
	 * costruttore
	 */
	public fewStorageMessageException() {
		super();
		System.out.println("IMPOSSIBILE PUBBLICARE,SONO RIMASTI POCHI POSTS");
	}

}