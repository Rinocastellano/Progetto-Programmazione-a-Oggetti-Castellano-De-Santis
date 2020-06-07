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
		ArrayList<Post> postFiltered1= new ArrayList<Post>();
		int i=0;
			Filter[] filter= new Filter[2];
			for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
				filter[i]= FilterService.filterFormulation(entry.getKey(), post, entry.getValue());
				i++;
			}
			postFiltered1=filter[0].doFilter();
			if(type.equals("or")||type.equals("and")) {
			postFiltered2=filter[1].doFilter();
			Set<Post> set = new LinkedHashSet<>(postFiltered1);
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
