package univpm.it.CastelDeSa.progettoOOP.stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;

public class statMax implements statCalcNum{
	//definisco l'arrayList da analizzare per la statistica
	private ArrayList<post> post=new ArrayList<post>();
	
	public statMax(ArrayList<post> post) {
		this.post=post;
	}
	
	public  statNum doStat() {
		//un'alternativa è con le HashMap, ma per ora rimane in cantiere
		/*ArrayList<String> posts=storageNumbers.GetNumbers(post);
		Map<Integer, Integer> counts = new HashMap<Integer,Integer>();
		statNum stat= new statNum();
		for(int i=0;i<posts.size();i++) {
			for(Integer key : counts.keySet()) {
				System.out.print(key);
			if(posts.get(i).length()>counts.)) {
				counts.clear();
				counts.put(posts.get(i).length(),1);
			}}
			if(counts.equals(posts.get(i).length())) {
				counts.put(posts.get(i).length(), counts.get(posts.get(i).length())+1);
				
			}
		}*/
		
		int max=0;
		int count=0;
		int i=0;
		for(i=0;i<post.size();i++){
			if(post.get(i).getMessage()!=null && post.get(i).getMessage().length()>max) {
				 max=post.get(i).getMessage().length();
				 count=0;
			 }
			 if(post.get(i).getMessage()!=null && post.get(i).getMessage().length()==max) {
				 count++;
			 }
			
		
		}
		statNum stat= new statNum();
		stat.setMax(max);
		return stat;
}
	
}
