package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;
/**
 * classe di filtro arrayList di post per un valore più grande scelto dall'utente
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class filterGt implements filter{
	private ArrayList<post> post= new ArrayList<post>();
	private ArrayList<String> param= new ArrayList<String>();

	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public filterGt(ArrayList<post> post, ArrayList<String> param) {
		this.post=post;
		this.param=param;
	}
	/**
	 * metodo di filtraggio
	 */
	public ArrayList<post> doFilter(){
		ArrayList<post> postFiltered =new ArrayList<post>();
		for(post p : post) {
			if(p.getMessage()!=null) {
			if(p.getMessage().length()>Integer.parseInt(param.get(0))) {
				postFiltered.add(p);}
		}
		}
		return postFiltered;
	}
} 