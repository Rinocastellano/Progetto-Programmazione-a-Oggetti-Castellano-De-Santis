package univpm.it.CastelDeSa.progettoOOP.stat;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class stat {

	 public static void main ( String [] args ) throws MalformedURLException {
		 
		 String url="https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD";
		 storageNumbers store= new storageNumbers(url); 
		 ArrayList<String>caratteri=store.Getnumbers();
		 ArrayList<Integer>numero_char=new ArrayList<Integer>();
		
		 String str;
		 String somma="";
		 int media;
		 int n=0;
		 int o;
		 int min=0;
		 int max=0;
		 int photo_video=0;
		 for(int i=0;i<caratteri.size();i++) {        //non levo i post con zero message perchè fanno parte della mia statistica//
			 str=caratteri.get(i);
			somma+=str;                                //la somma di tutte le stringhe(message)//
			n++;
		
		 }
		 media=somma.length()/n;
		
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
		 
		 
		 for(int i=0;i<numero_char.size();i++){
		 if(numero_char.get(i)>max) {
			 max=numero_char.get(i); 
		 }
		 
		 if(numero_char.get(i)<=min) {
			 min=numero_char.get(i);
			 
			 
		 }
		 
	    }
		 
		 System.out.println(min);
		 System.out.println(max);
		 System.out.println(photo_video);
		 System.out.println(media);
		 
    }
}	 
		 
	 
	

