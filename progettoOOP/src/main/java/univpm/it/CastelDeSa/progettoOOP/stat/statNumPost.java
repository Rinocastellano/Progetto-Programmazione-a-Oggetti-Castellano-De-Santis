package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;

/**
 * classe utile al calcolo del numero totale dei post
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class statNumPost implements statCalculate{
	
	
	private ArrayList<post> post=new ArrayList<post>();
	
	public statNumPost(ArrayList<post> post) {
		this.post=post;
	}
	/**
	 * override del metodo dell'interfaccia statCalc dostat()
	 */
	public  statNum doStat() {
		statNum stat=new statNum();
		stat.setNumTotalePost(post.size());
		return stat;
	}

}
