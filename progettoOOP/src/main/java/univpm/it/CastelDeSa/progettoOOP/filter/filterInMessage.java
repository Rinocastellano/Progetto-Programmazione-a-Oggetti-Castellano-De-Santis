package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterInMessage implements filter{
	public ArrayList<post> doFilter(ArrayList<post> post){
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().contains("Vasco"))
				postFiltered.add(p);}
		}
		return postFiltered;
	}

}
