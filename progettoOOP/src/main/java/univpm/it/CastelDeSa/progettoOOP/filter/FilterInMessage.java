package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import univpm.it.CastelDeSa.progettoOOP.model.Post;

/**
 * classe di filtro arrayList di post, utile alla ricerca di una determinata stringa di caratteri
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class FilterInMessage extends FilterIn implements Filter{

	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public FilterInMessage(ArrayList<Post> post, ArrayList<String> spec) {
		super(post, spec);
	}
	/**
	 * metodo di filtraggio
	 */
	public ArrayList<Post> doFilter() {
		ArrayList<Post> postFiltered =new ArrayList<Post>();
		for(String s : spec) {
		for(Post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().contains(s))
				postFiltered.add(p);}
		}
		}
		return postFiltered;
	}




}