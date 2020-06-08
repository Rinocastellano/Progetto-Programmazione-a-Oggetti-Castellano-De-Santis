package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.model.StatPres;

/**
 * classe utile al calcolo del numero totale dei post
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class StatPresMult implements StatCalculate{
	
	
	private ArrayList<Post> post=new ArrayList<Post>();
	
	public StatPresMult(ArrayList<Post> post) {
		this.post=post;
	}
	/**
	 * override del metodo dell'interfaccia statCalc dostat()
	 */
	public  StatPres doStat() {
		int n=0;
		StatPres stat=new StatPres();
		for(Post post : post) {
			if(post.getMessage()==null) 
			n++;
		 }
		if(n!=0)
			stat.setPres(true);
		else
			stat.setPres(false);
			stat.setNumPost(n);
			stat.setSpec("numero di post con multimedia");
		return stat;
	}

}
