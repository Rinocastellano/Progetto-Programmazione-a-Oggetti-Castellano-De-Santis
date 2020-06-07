package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.Post;

/**
 * classe di filtro arrayList di post per un valore più basso scelto dall'utente
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class FilterLt implements Filter{

	private ArrayList<Post> post= new ArrayList<Post>();
	private ArrayList<String> param= new ArrayList<String>();
	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public FilterLt(ArrayList<Post> post, ArrayList<String> param) {
		this.post=post;
		this.param=param;
	}
	/**
	 * metodo di filtraggio
	 */
	public  ArrayList<Post> doFilter(){
		ArrayList<Post> postFiltered =new ArrayList<Post>();
		for(Post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().length()<Integer.parseInt(param.get(0)))
				postFiltered.add(p);}
		}
		return postFiltered;
	}
}