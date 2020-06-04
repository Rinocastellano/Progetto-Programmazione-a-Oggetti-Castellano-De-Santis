package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterBt {
	public  ArrayList<post> doFilter(ArrayList<post> post){
		ArrayList<post> postFiltered =new ArrayList<post>();
		postFiltered=filterGt.doFilter(post);
		return postFiltered= filterLt.doFilter(postFiltered);
	}
	

}
