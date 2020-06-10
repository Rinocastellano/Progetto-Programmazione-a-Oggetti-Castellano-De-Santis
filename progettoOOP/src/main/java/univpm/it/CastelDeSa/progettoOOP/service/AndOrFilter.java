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

import univpm.it.CastelDeSa.progettoOOP.exceptions.BetweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.CommandException;

import univpm.it.CastelDeSa.progettoOOP.filter.Filter;
import univpm.it.CastelDeSa.progettoOOP.model.Post;

public class AndOrFilter {
	/**
	 * dato il tipo di filtraggio (and,or, default), l'elenco di post da filtrare ed i parametri di 
	 * filtraggio (in,Nin,Gt,...) calcolo elenco di post che rispettano tali specifiche
	 * @param type , specifica di filtraggio avanzata nel caso di molteplici richieste (and,or,default)
	 * @param post , elenco di post da filtrare
	 * @param map , hashmap avente key=tipo di filtraggio(in,gt,nin,lt,bt,...) e value=parametri di filtraggio
	 * @return elenco dei post filtrati
	 * @throws commandStatException
	 * @throws BetweenWrongValueException
	 */
	public static ArrayList<Post> andOrFiltering(String type,ArrayList<Post> post, HashMap<String,ArrayList<String>> map) throws CommandException, BetweenWrongValueException{
		ArrayList<Post> postFiltered2= new ArrayList<Post>();
		ArrayList<Post> postFiltered1= post;
			ArrayList<Filter> filter= new ArrayList<Filter>();
			for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
				filter.add(FilterService.filterFormulation(entry.getKey(), post, entry.getValue()));
			}
			postFiltered1=filter.get(0).doFilter();
			filter.remove(0);
			if(type.equals("or")||type.equals("and")) {
				for(Filter f : filter) {
					Set<Post> set = new LinkedHashSet<>(postFiltered1);
					postFiltered2=f.doFilter();
					if(type.equals("or")) {
						set.addAll(postFiltered2);
					}
					if(type.equals("and")) {
						set.retainAll(postFiltered2);
					}
					postFiltered2=new ArrayList<>(set);
					postFiltered1=postFiltered2;
				}
					
			}
		return postFiltered1;
	}
}
