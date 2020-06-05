package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterInMessage extends filterIn implements filter{
	

	public filterInMessage(ArrayList<post> post, ArrayList<String> spec) {
		super(post, spec);
	}
	
	public ArrayList<post> doFilter() {
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(String s : spec) {
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().contains(s))
				postFiltered.add(p);}
		}
		}
		return postFiltered;
	}
	
	
	

}
