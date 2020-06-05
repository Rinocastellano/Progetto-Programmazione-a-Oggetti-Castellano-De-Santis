package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterLt implements filter{

	private ArrayList<post> post= new ArrayList<post>();
	private ArrayList<String> param= new ArrayList<String>();
	
	public filterLt(ArrayList<post> post, ArrayList<String> param) {
		this.post=post;
		this.param=param;
	}
	public  ArrayList<post> doFilter(){
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().length()<Integer.parseInt(param.get(0)))
				postFiltered.add(p);}
		}
		return postFiltered;
	}
}
