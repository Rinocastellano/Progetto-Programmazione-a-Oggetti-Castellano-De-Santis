package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.exceptions.BetweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
/**
 * interfaccia filtro
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public interface Filter {
/**
 * metodo di filtraggio
 * @return arrayList di post filtrati
 * @throws BetweenWrongValueException
 */
	public  ArrayList<Post> doFilter() throws BetweenWrongValueException;
}