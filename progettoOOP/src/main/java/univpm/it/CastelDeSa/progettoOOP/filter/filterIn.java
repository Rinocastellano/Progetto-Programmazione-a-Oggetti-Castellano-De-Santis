package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;

import ch.qos.logback.core.filter.Filter;
import univpm.it.CastelDeSa.progettoOOP.model.post;
/**
 * classe astratta di filtro arrayList di post, utile alla ricerca di un determinato contenuto nel message
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public abstract class filterIn implements filter{

	protected ArrayList<String> spec= new ArrayList<String>();
	protected ArrayList<post> post= new ArrayList<post>();
	/**
	 * costruttore
	 * @param post arrayList di post
	 * @param param arrayList di stringhe contenenti i parametri di filtraggio
	 */
	public filterIn(ArrayList<post> post, ArrayList<String> spec) {
		this.post=post;
		this.spec=spec;


	}
	
	/**
	 * metodo di filtraggio
	 */
	public abstract ArrayList<post> doFilter();


}