package univpm.it.CastelDeSa.progettoOOP.exceptions;

public class fewStorageMessageException extends Exception {
	public fewStorageMessageException() {
		super();
		System.out.println("IMPOSSIBILE PUBBLICARE,SONO RIMASTI POCHI POSTS");
	}

}
