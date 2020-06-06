package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import java.util.Iterator;

import univpm.it.CastelDeSa.progettoOOP.model.post;
/**
 * classe di filtro arrayList di post, utile alla ricerca di post
 * senza determinate stringhe di caratteri
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class filterNInMessage extends filterIn implements filter {
	private ArrayList<post> post= new ArrayList<post>();
	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public filterNInMessage(ArrayList<post> post, ArrayList<String> spec) {
		super(post,spec);
	}
	/**
	 * metodo di filtraggio
	 */
	public  ArrayList<post> doFilter(){
		ArrayList<post> postFiltered =new ArrayList<post>();
		postFiltered=post;
		for(String s : spec) {
		for(Iterator<post> it= postFiltered.iterator();it.hasNext();) {
			post p= it.next();
			if(p.getMessage()!=null) {
			if(p.getMessage().contains(s))
				it.remove();
			}
		}
		}
		return postFiltered;
	}


}
