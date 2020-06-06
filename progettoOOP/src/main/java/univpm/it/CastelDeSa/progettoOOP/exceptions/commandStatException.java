package univpm.it.CastelDeSa.progettoOOP.exceptions;

/**
 * classe di eccezione per stringa errata nella creazione classe stat/filter
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class commandStatException extends ClassNotFoundException {
	/**
	 * classe costruttore
	 * @param e , eccezione di tipo ClassNotFound
	 */
	public commandStatException(ClassNotFoundException e) {
		super();
		System.out.println("STRINGA COMMAND NON VALIDA");
	}
}
