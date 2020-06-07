package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.model.Stat;
import univpm.it.CastelDeSa.progettoOOP.model.StatNum;

/**
 * classe per il calcolo del post con minor numero di caratteri(esclusi i post con foto/video, considerati di default SENZA char
 * dato un arrayList di post da analizzare, calcolo statistica
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class StatMin implements StatCalculate{

private ArrayList<Post> post=new ArrayList<Post>();
	
	public StatMin(ArrayList<Post> post) {
		this.post=post;
	}
	
	/**
	 * override del metodo doStat() di statCalcNum
	 */
	@Override
	public StatNum doStat() {
		int min;
		Map<String,Integer> map= new HashMap<String,Integer>();
		for(Post record : post) {
			if(record.getMessage()!=null) {
				map.put(record.getMessage(), record.getMessage().length());
			}
		}
		min=Collections.min(map.values());
		StatNum stat= new StatNum();
		stat.setMin(min);
		stat.setSpec("lunghezza minima");
		return stat;
	}
	

}
