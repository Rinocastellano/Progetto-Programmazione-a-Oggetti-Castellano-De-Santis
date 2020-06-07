package univpm.it.CastelDeSa.progettoOOP.filter;

import java.util.ArrayList;
import univpm.it.CastelDeSa.progettoOOP.exceptions.*;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
/**
 * classe di filtro arrayList di post tra due valori di lunghezza message
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class FilterBt implements Filter{

	private ArrayList<Post> post= new ArrayList<Post>();
	private ArrayList<String> param= new ArrayList<String>();
/**
 * costruttore
 * @param post arrayList di post
 * @param param arrayList di stringhe contenenti i parametri di filtraggio
 */
	public FilterBt(ArrayList<Post> post, ArrayList<String> param) {
		this.post=post;
		this.param=param;
	}

/**
 * metodo di filtraggio
 */
	public  ArrayList<Post> doFilter() throws BetweenWrongValueException  {
		if(Integer.parseInt(param.get(0))>=Integer.parseInt(param.get(1)))  {
			throw new BetweenWrongValueException();

		}
		ArrayList<Post> postFiltered =new ArrayList<Post>();
		FilterGt filterG= new FilterGt(post,param);
		postFiltered=filterG.doFilter();
		param.remove(0);
		FilterLt filterL = new FilterLt(postFiltered,param);
		return postFiltered= filterL.doFilter();
	}


}