package univpm.it.CastelDeSa.progettoOOP.exceptions;

/**
 * classe di eccezione relativa all'errore di inserimento di valori per il filtro between
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class betweenWrongValueException extends Exception {

	/**
	 * classe costruttore
	 */
	public betweenWrongValueException() {

		System.out.println("PARAMETRI INSERITI NON VALIDI, UGUALI O SECONDO VALORE MINORE DEL PRIMO");


	}


}