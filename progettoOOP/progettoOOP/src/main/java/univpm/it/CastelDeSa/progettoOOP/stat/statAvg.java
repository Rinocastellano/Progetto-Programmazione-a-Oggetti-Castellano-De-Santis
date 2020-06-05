package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;

/**
 * classe utile al calcolo della lunghezza media dei post
 * @author Castellano Rino
 * 
 */
public class statAvg implements statCalculate{
	
	
	private ArrayList<post> post=new ArrayList<post>();
	
	public statAvg(ArrayList<post> post) {
		this.post=post;
	}
	/**
	 * override del metodo dell'interfaccia statCalcNum dostat()
	 */
	public  statNum doStat() {
		int somma=0;
		int n=0;
		for(int i=0;i<post.size();i++) {
			if(post.get(i).getMessage()!=null) {
				somma+=post.get(i).getMessage().length();
			}
			n++;

		 }
		statNum stat= new statNum();
		stat.setAvg(somma/n);
		return stat;
	}

}
