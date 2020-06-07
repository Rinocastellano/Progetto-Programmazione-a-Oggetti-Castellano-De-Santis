package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
/**
 * classe astratta di filtro arrayList di post, utile alla ricerca di un determinato contenuto nel message
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public abstract class FilterIn implements Filter{

	protected ArrayList<String> spec= new ArrayList<String>();
	protected ArrayList<Post> post= new ArrayList<Post>();
	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public FilterIn(ArrayList<Post> post, ArrayList<String> spec) {
		this.post=post;
		this.spec=spec;


	}
	
	/**
	 * metodo di filtraggio
	 */
	public abstract ArrayList<Post> doFilter();


}