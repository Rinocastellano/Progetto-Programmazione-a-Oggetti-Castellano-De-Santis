package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterInMessage extends filterIn implements filter{

	public filterInMessage(ArrayList<post> post, String spec) {
		super(post, spec);
	}
	
	public ArrayList<post> doFilter() {
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().contains(spec))
				postFiltered.add(p);}
		}
		return postFiltered;
	}
	
	
	

}
