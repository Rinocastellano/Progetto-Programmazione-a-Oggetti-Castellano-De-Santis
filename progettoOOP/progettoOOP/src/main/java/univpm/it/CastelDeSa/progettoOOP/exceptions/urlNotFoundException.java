package univpm.it.CastelDeSa.progettoOOP.exceptions;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class urlNotFoundException extends Exception {
	public urlNotFoundException ( UnknownHostException e) {
		super();
		System.out.println("URL NON TROVATO");
	}
}
