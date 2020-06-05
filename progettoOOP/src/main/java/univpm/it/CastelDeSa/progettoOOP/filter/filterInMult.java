package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterInMult extends filterIn implements filter{
	
	public filterInMult(ArrayList<post> post, ArrayList<String> spec) {
		super(post,spec);
	}

	public  ArrayList<post> doFilter() {
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(post p : post) {
			if(p.getMessage()==null) 
				postFiltered.add(p);
		}
		return postFiltered;
	}
}


