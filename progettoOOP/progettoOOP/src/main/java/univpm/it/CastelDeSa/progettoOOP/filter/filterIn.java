package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import ch.qos.logback.core.filter.Filter;
import univpm.it.CastelDeSa.progettoOOP.model.post;

public abstract class filterIn implements filter{
	
	protected ArrayList<String> spec= new ArrayList<String>();
	protected ArrayList<post> post= new ArrayList<post>();
	
	public filterIn(ArrayList<post> post, ArrayList<String> spec) {
		this.post=post;
		this.spec=spec;
	
		
	}
	public abstract ArrayList<post> doFilter();
	

}
