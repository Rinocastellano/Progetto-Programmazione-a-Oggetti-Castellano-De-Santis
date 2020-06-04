package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;

/**
 * classe per il calcolo del post con minor numero di caratteri(esclusi i post con foto/video, considerati di default SENZA char
 * dato un arrayList di post da analizzare, calcolo statistica
 * @author Castellano Rino
 *
 */
public class statMin implements statCalculate{

private ArrayList<post> post=new ArrayList<post>();
	
	public statMin(ArrayList<post> post) {
		this.post=post;
	}
	
	/**
	 * override del metodo doStat() di statCalcNum
	 */
	@Override
	public statNum doStat() {
		int min;
		Map<String,Integer> map= new HashMap<String,Integer>();
		for(post record : post) {
			if(record.getMessage()!=null) {
				map.put(record.getMessage(), record.getMessage().length());
			}
		}
		min=Collections.min(map.values());
		statNum stat= new statNum();
		stat.setMin(min);
		return stat;
	}
	

}
