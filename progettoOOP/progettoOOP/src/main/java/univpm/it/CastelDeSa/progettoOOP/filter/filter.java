package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.exceptions.betweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.model.post;

public interface filter {

	public  ArrayList<post> doFilter() throws betweenWrongValueException;
}
