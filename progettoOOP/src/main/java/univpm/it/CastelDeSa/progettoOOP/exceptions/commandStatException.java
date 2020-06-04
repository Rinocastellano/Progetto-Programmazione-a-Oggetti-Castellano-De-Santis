package univpm.it.CastelDeSa.progettoOOP.exceptions;

public class commandStatException extends ClassNotFoundException {
	
	public commandStatException(ClassNotFoundException e) {
		super();
		System.out.println("STRINGA COMMAND NON VALIDA");
	}
}
