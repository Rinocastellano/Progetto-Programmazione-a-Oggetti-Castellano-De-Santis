package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterGt {
	public static ArrayList<post> doFilter(ArrayList<post> post){
		ArrayList<post> postFiltered =new ArrayList<post>();
		int n=50;
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().length()>n)
				postFiltered.add(p);}
		}
		return postFiltered;
	}

}
