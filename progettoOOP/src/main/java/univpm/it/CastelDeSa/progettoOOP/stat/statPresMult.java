package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;
import univpm.it.CastelDeSa.progettoOOP.model.statPres;

/**
 * classe utile al calcolo del numero totale dei post
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class statPresMult implements statCalculate{
	
	
	private ArrayList<post> post=new ArrayList<post>();
	
	public statPresMult(ArrayList<post> post) {
		this.post=post;
	}
	/**
	 * override del metodo dell'interfaccia statCalc dostat()
	 */
	public  statPres doStat() {
		int n=0;
		statPres stat=new statPres();
		for(post post : post) {
			if(post.getMessage()==null) 
			n++;
		 }
		if(n!=0)
			stat.setPres(true);
		else
			stat.setPres(false);
			stat.setNumPost(n);
		return stat;
	}

}
