package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.exceptions.betweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.model.post;
/**
 * interfaccia filtro
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public interface filter {
/**
 * metodo di filtraggio
 * @return arrayList di post filtrati
 * @throws betweenWrongValueException
 */
	public  ArrayList<post> doFilter() throws betweenWrongValueException;
}