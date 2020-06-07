package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.model.Stat;
import univpm.it.CastelDeSa.progettoOOP.model.StatNum;

/**
 * classe utile al calcolo della lunghezza media dei post
 * @author Castellano Rino
 * @author Matteo De Santis
 */
public class StatAvg implements StatCalculate{
	
	
	private ArrayList<Post> post=new ArrayList<Post>();
	
	public StatAvg(ArrayList<Post> post) {
		this.post=post;
	}
	/**
	 * override del metodo dell'interfaccia statCalcNum dostat()
	 */
	public  StatNum doStat() {
		int somma=0;
		int n=0;
		for(int i=0;i<post.size();i++) {
			if(post.get(i).getMessage()!=null) {
				somma+=post.get(i).getMessage().length();
			}
			n++;

		 }
		StatNum stat= new StatNum();
		stat.setAvg(somma/n);
		stat.setSpec("lunghezza media post");
		return stat;
	}

}
