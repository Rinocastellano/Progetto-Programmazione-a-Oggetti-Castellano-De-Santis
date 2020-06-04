package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import java.util.Iterator;

import univpm.it.CastelDeSa.progettoOOP.model.post;

public class filterNInMessage {
	
	public static ArrayList<post> doFilter(ArrayList<post> post){
		ArrayList<post> postFiltered =new ArrayList<post>();
		postFiltered=post;
		for(Iterator<post> it= postFiltered.iterator();it.hasNext();) {
			post p= it.next();
			if(p.getMessage()!=null) {
			if(p.getMessage().contains("Vasco"))
				it.remove();
			}
		}
		return postFiltered;
	}


}

