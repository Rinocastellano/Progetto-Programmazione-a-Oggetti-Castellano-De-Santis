package univpm.it.CastelDeSa.progettoOOP.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import univpm.it.CastelDeSa.progettoOOP.exceptions.commandStatException;
import univpm.it.CastelDeSa.progettoOOP.filter.filter;
import univpm.it.CastelDeSa.progettoOOP.model.post;

public class andOrFilter {
	
	public static ArrayList<post> andOrFiltering(String type,ArrayList<post> post, HashMap<String,ArrayList<String>> map) throws commandStatException{
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
		//filter filter1= filterService.filterFormulation(, post, map.get(key));
		
		//return postFiltered1=filter1.doFilter();
		
	}
}
