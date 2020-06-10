package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import java.util.Iterator;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
/**
 * classe di filtro arrayList di post, utile alla ricerca di post
 * senza determinate stringhe di caratteri
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class FilterNInMult extends FilterIn implements Filter{
	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public FilterNInMult(ArrayList<Post> post, ArrayList<String> spec) {
		super(post,spec);
	}
	/**
	 * metodo di filtraggio
	 */
	public ArrayList<Post> doFilter(){
		ArrayList<Post> postFiltered =new ArrayList<Post>();
		postFiltered=post;
		for(Iterator<Post> it= postFiltered.iterator();it.hasNext();) {
			for(Post p : post) {
				if(p.getMessage()==null) {
					post.add(p);
					}
			}
		}
		return postFiltered;
		}
}
