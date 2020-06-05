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
		statPres stat=new statPres();
		for(post record : post) {
			if(record.getMessage()==null) {
				stat.setPres(true);
				return stat;
				
			}
		}
		stat.setPres(false);
		return stat;
	}

}
