package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
/**
 * classe di filtro arrayList di post, utile alla ricerca di un contenuto multimediale
 * (message=null)
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class FilterInMult extends FilterIn implements Filter{
	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public FilterInMult(ArrayList<Post> post, ArrayList<String> spec) {
		super(post,spec);
	}
	/**
	 * metodo di filtraggio
	 */
	public  ArrayList<Post> doFilter() {
		ArrayList<Post> postFiltered =new ArrayList<Post>();
		for(Post p : post) {
			if(p.getMessage()==null) 
				postFiltered.add(p);
		}
		return postFiltered;
	}
}