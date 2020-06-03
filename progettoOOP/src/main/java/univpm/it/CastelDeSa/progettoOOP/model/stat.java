package univpm.it.CastelDeSa.progettoOOP.model;

import java.net.MalformedURLException;
import java.util.ArrayList;

import univpm.it.CastelDeSa.progettoOOP.stat.storageNumbers;

public class stat {
	
	String spec;
	public stat() {
	}
	public stat(String s) {
		this.spec=s;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
		
	
		 

		 /*ArrayList<post> storage= postStorage.posts;
		 ArrayList<String>caratteri=storageNumbers.GetNumbers(storage);
		 ArrayList<Integer>numero_char=new ArrayList<Integer>();

		 String str;
		 String somma="";
		 int media;
		 int n=0;
		 int o;
		 int min=0;
		 int max=0;
		 int photo_video=0;


		 System.out.println(somma);

		 for(int i=0;i<caratteri.size();i++) {             //trovo foto e video e costruisco array dove ho zero invece che null//
				if(caratteri.get(i)!=null) {

					 str=caratteri.get(i);
					 o=str.length();
					 numero_char.add(o);
				}
				else {
					o=0;
					numero_char.add(o);
					photo_video++;
		          }	
		     }	

		 if(numero_char.get(i)<=min) {
			 min=numero_char.get(i);


		 }

	    }

		 System.out.println(min);
		 System.out.println(max);
		 System.out.println(photo_video);
		 System.out.println(media);*/

}	 
