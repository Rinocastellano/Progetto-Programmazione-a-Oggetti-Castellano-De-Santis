package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterInMult {

	public static  ArrayList<post> doFilter(ArrayList<post> post) {
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(post p : post) {
			if(p.getMessage()==null) 
				postFiltered.add(p);
		}
		return postFiltered;
	}
}


