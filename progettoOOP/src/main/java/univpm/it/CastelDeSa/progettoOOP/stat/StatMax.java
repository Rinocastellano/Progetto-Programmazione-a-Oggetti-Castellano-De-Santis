package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.model.Stat;
import univpm.it.CastelDeSa.progettoOOP.model.StatNum;

/**
 * classe per il calcolo del post con max numero di caratteri, dato un ArrayList di post
 * 
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class StatMax implements StatCalculate {
	//definisco l'arrayList da analizzare per la statistica
	private ArrayList<Post> post=new ArrayList<Post>();
	
	public StatMax(ArrayList<Post> post) {
		this.post=post;
	}
	
	/**
	 * metodo di calcolo statistica, implementato dal più generico statCalcNum
	 */
	@Override
	public  StatNum doStat() {
	
		int max;
		Map<String,Integer> map= new HashMap<String,Integer>();
		for(Post record : post) {
			if(record.getMessage()!=null) {
				map.put(record.getMessage(), record.getMessage().length());
			}
		}
		max=Collections.max(map.values());
		StatNum stat= new StatNum();
		stat.setMax(max);
		stat.setSpec("Lunghezza max post");
		return stat;
		
}
}
