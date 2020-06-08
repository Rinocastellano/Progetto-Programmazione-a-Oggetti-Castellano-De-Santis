package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.model.StatNum;

/**
 * classe utile al calcolo del numero totale dei post
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class StatNumPost implements StatCalculate{
	
	private ArrayList<Post> post=new ArrayList<Post>();
	
	public StatNumPost(ArrayList<Post> post) {
		this.post=post;
	}
	/**
	 * override del metodo dell'interfaccia statCalc dostat()
	 */
	public  StatNum doStat() {
		StatNum stat=new StatNum();
		stat.setNumTotalePost(post.size());
		stat.setSpec("numero di post");
		return stat;
	}

}
