package univpm.it.CastelDeSa.progettoOOP.service;
/**
 * classe calcolante filtraggio post
 * @author Rino Castellano
 * @author Matteo De Santis
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import univpm.it.CastelDeSa.progettoOOP.exceptions.betweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.commandStatException;
import univpm.it.CastelDeSa.progettoOOP.filter.filter;
import univpm.it.CastelDeSa.progettoOOP.model.post;

public class andOrFilter {
	/**
	 * dato il tipo di filtraggio (and,or, default), l'elenco di post da filtrare ed i parametri di 
	 * filtraggio (in,Nin,Gt,...) calcolo elenco di post che rispettano tali specifiche
	 * @param type , specifica di filtraggio avanzata nel caso di molteplici richieste (and,or,default)
	 * @param post , elenco di post da filtrare
	 * @param map , hashmap avente key=tipo di filtraggio(in,gt,nin,lt,bt,...) e value=parametri di filtraggio
	 * @return elenco dei post filtrati
	 * @throws commandStatException
	 * @throws betweenWrongValueException
	 */
	public static ArrayList<post> andOrFiltering(String type,ArrayList<post> post, HashMap<String,ArrayList<String>> map) throws commandStatException, betweenWrongValueException{
		ArrayList<post> postFiltered2= new ArrayList<post>();
		ArrayList<post> postFiltered1= new ArrayList<post>();
		int i=0;
			filter[] filter= new filter[2];
			for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
				filter[i]= filterService.filterFormulation(entry.getKey(), post, entry.getValue());
				i++;
			}
			postFiltered1=filter[0].doFilter();
			if(type.equals("or")||type.equals("and")) {
			postFiltered2=filter[1].doFilter();
			Set<post> set = new LinkedHashSet<>(postFiltered1);
			if(type.equals("or")) {
			set.addAll(postFiltered2);
			postFiltered2= new ArrayList<>(set);
			return postFiltered2;
			}
		
		else if(type.equals("and")) {
			set.retainAll(postFiltered2);
			postFiltered2=new ArrayList<>(set);
			return postFiltered2;
		}
		}
		
		return postFiltered1;
		
	}
}
