package univpm.it.CastelDeSa.progettoOOP.service;


import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


import org.yaml.snakeyaml.util.UriEncoder;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import util.httpRequest;
import util.reading;
import util.writing;

/**
 * classe utile all'inserimento di post programmati randomici presi da file esterno
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class temporizationPosting {
	
	static SimpleDateFormat formatterFromPosting= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	static SimpleDateFormat formatterFromRecord= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS");
	
	/**
	 * Metodo calcolante
	 * I seguenti parametri corrispondono alla data richiesta dall'utente per la pubblicazione
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @param post
	 * @return ArrayList<post> il solito elenco di post AGGIORNATO
	 * @throws IOException
	 * @throws org.apache.hc.core5.http.ParseException 
	 * @throws URISyntaxException 
	 */
	
	public static String temporizzatedPosting(post newPost, ArrayList<post> post) throws IOException, org.apache.hc.core5.http.ParseException, URISyntaxException {
		
		//boolean test=isGreaterThanCurrentTime(newCreatedTime); NECESSITO EXCEPTION
		String messageOut="";
		String newCreatedTime=newPost.getCreated_time();
		String lastCreatedTime=post.get(0).getCreated_time();
		newCreatedTime=calcoloDatePosting(newCreatedTime, lastCreatedTime);

		//creazione istantanea dell'arrayList di post randomici + selezione del post
		ArrayList<String> postRandom = reading.readFile("C:\\Users\\vito\\Desktop\\jsonrandom.txt");
		Random random = new Random();
		int num=random.nextInt(postRandom.size());
		String message=postRandom.get(num);
		System.out.println(message);
		
		//rimozione post random scelto dal nostro array di interesse ed anche dal file per un possibile riutilizzo
		postRandom.remove(num);
		if(postRandom.size()<3) {
			messageOut="Attenzione! Post randomici in esaurimento!";
		}
		writing.writingFile("C:\\Users\\vito\\Desktop\\jsonrandom.txt", postRandom);
		
		//creazione post
		String url="https://graph.facebook.com/107920467600716/feed?published=false&access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD&message="+UriEncoder.encode(message)+"&scheduled_publish_time="+newPost.getCreated_time();
		//...da finire, problemi con connessione per posting, otterrò anche un id
		String indexPost=httpRequest.postRequest(url, newCreatedTime);
		messageOut="Post pubblicato con l'id seguente: "+indexPost+"\n"+messageOut;
		
		//qualora la richiesta fosse accettata -> inserimento post in arraylist post
		post.add(0, new post(newCreatedTime,indexPost,message));
		
		
		return messageOut;
		}
		
	
	
	//calcola, se c'è necessità di cambiare orario per il posting, il nuovo orario per il post
	
	/**
	 * Calcola, se c'è la necessià, di posticipare l'orario per il posting con un orario spostato di 4h rispetto 
	 * all'ultimo post
	 * @param newCreatedTime
	 * @param lastCreatedTime
	 * @return il nuovo orario 
	 */
	public static String calcoloDatePosting(String newCreatedTime, String lastCreatedTime) {
		Date newPostFormatted=null;
		Date lastPostFormatted=null;
		
		try {
			newPostFormatted = formatterFromPosting.parse(newCreatedTime);
			lastPostFormatted= formatterFromRecord.parse(lastCreatedTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if((newPostFormatted.getTime()-lastPostFormatted.getTime())<14400000 &&(newPostFormatted.getTime()-lastPostFormatted.getTime())>-14400000) {
		Calendar calendar= Calendar.getInstance();
		 calendar.setTime(lastPostFormatted);
		 calendar.add(Calendar.HOUR_OF_DAY, 4);
		 newPostFormatted=calendar.getTime();
		}
		
		return formatterFromPosting.format(newPostFormatted);
	}
	
}
