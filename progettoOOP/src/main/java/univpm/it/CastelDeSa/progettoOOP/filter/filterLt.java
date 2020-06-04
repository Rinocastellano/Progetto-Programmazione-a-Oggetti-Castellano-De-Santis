package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterLt implements filter{

	private ArrayList<post> post= new ArrayList<post>();
	
	public filterLt(ArrayList<post> post) {
		this.post=post;
	}
	public  ArrayList<post> doFilter(){
		ArrayList<post> postFiltered =new ArrayList<post>();
		int n=100;
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().length()<n)
				postFiltered.add(p);}
		}
		return postFiltered;
	}
}
