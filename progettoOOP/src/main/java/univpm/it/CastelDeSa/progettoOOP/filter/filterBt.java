package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterBt implements filter{

	private ArrayList<post> post= new ArrayList<post>();
	private ArrayList<String> param= new ArrayList<String>();
	
	public filterBt(ArrayList<post> post, ArrayList<String> param) {
		this.post=post;
		this.param=param;
	}
	
	public  ArrayList<post> doFilter(){
		ArrayList<post> postFiltered =new ArrayList<post>();
		filterGt filterG= new filterGt(post,param);
		postFiltered=filterG.doFilter();
		param.remove(0);
		filterLt filterL = new filterLt(postFiltered,param);
		return postFiltered= filterL.doFilter();
	}
	

}
