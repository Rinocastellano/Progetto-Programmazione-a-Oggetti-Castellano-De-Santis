package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;

public class statAvg implements statCalcNum{
	private ArrayList<post> post=new ArrayList<post>();
	
	public statAvg(ArrayList<post> post) {
		this.post=post;
	}
	
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
