package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;

public class statAvg {
	
	public static statNum doStat(ArrayList<post> post) {
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
