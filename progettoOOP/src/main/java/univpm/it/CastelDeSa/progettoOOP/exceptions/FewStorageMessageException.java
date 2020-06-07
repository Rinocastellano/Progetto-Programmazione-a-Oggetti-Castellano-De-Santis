package univpm.it.CastelDeSa.progettoOOP.exceptions;
/**
 * classe di eccezione per basso numero di message per post temporizzato randomico
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class FewStorageMessageException extends Exception {
	/**
	 * costruttore
	 */
	public FewStorageMessageException() {
		super();
		System.out.println("IMPOSSIBILE PUBBLICARE,SONO RIMASTI POCHI POSTS");
	}

}