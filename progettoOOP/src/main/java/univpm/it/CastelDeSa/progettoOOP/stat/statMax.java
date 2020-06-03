package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;

/**
 * classe per il calcolo del post con max numero di caratteri, dato un ArrayList di post
 * 
 * @author Castellano Rino
 *
 */
public class statMax implements statCalc{
	//definisco l'arrayList da analizzare per la statistica
	private ArrayList<post> post=new ArrayList<post>();
	
	public statMax(ArrayList<post> post) {
		this.post=post;
	}
	
	/**
	 * metodo di calcolo statistica, implementato dal più generico statCalcNum
	 */
	@Override
	public  statNum doStat() {
	
		int max;
		Map<String,Integer> map= new HashMap<String,Integer>();
		for(post record : post) {
			if(record.getMessage()!=null) {
				map.put(record.getMessage(), record.getMessage().length());
			}
		}
		max=Collections.max(map.values());
		statNum stat= new statNum();
		stat.setMin(max);
		return stat;
		
		
}
	
}
