package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterBt implements filter{

	private ArrayList<post> post= new ArrayList<post>();
	
	public filterBt(ArrayList<post> post) {
		this.post=post;
	}
	
	public  ArrayList<post> doFilter(){
		ArrayList<post> postFiltered =new ArrayList<post>();
		filterGt filterG= new filterGt(postFiltered);
		postFiltered=filterG.doFilter();
		filterLt filterL = new filterLt(postFiltered);
		return postFiltered= filterL.doFilter();
	}
	

}
