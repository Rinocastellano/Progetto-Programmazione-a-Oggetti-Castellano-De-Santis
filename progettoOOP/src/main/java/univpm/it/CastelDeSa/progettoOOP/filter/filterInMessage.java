package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import univpm.it.CastelDeSa.progettoOOP.model.post;

/**
 * classe di filtro arrayList di post, utile alla ricerca di una determinata stringa di caratteri
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class filterInMessage extends filterIn implements filter{

	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public filterInMessage(ArrayList<post> post, ArrayList<String> spec) {
		super(post, spec);
	}
	/**
	 * metodo di filtraggio
	 */
	public ArrayList<post> doFilter() {
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(String s : spec) {
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().contains(s))
				postFiltered.add(p);}
		}
		}
		return postFiltered;
	}




}