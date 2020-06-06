package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;
/**
 * classe di filtro arrayList di post, utile alla ricerca di un contenuto multimediale
 * (message=null)
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class filterInMult extends filterIn implements filter{
	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public filterInMult(ArrayList<post> post, ArrayList<String> spec) {
		super(post,spec);
	}
	/**
	 * metodo di filtraggio
	 */
	public  ArrayList<post> doFilter() {
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(post p : post) {
			if(p.getMessage()==null) 
				postFiltered.add(p);
		}
		return postFiltered;
	}
}