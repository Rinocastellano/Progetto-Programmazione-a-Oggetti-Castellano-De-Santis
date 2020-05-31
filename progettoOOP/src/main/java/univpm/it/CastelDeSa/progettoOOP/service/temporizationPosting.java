package univpm.it.CastelDeSa.progettoOOP.service;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.reading;
import univpm.it.CastelDeSa.progettoOOP.model.writing;

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
	 */
	
	public static ArrayList<post> temporizzatedPosting(String newCreatedTime, ArrayList<post> post) throws IOException {
		
		//boolean test=isGreaterThanCurrentTime(newCreatedTime); //NECESSITO EXCEPTION
		int cont=0;
		String lastCreatedTime=post.get(cont).getCreated_time();
		newCreatedTime=calcoloDatePosting(newCreatedTime, lastCreatedTime);
		//ricerca del post che coincide con le nostre richieste di post inerenti al tempo
		
		/*while(onlyDiff(newCreatedTime,lastCreatedTime)) {
			cont++;
		}
		cont--;
		
		//ciclo per cercare un buco per il posting
		while(onlyDiff(newCreatedTime,lastCreatedTime)) {
		newCreatedTime=calcoloDatePosting(newCreatedTime,lastCreatedTime);
		cont--;
		}
		
		//condizione per sistemare nella posizione giusta il post
		if(newIsGreater(newCreatedTime,lastCreatedTime)) {
			cont++;
		}

		*/
		//lettura da file//

		
		ArrayList<String> postRandom = reading.readFile("C:\\Users\\vito\\Desktop\\jsonrandom.txt");

		
		//scelta post random da postare
		Random random = new Random();
		int num=random.nextInt(postRandom.size());
		String message=postRandom.get(num);
		System.out.println(message);
		
		//rimozione post random scelto
		postRandom.remove(num);
		
		//riscrittura del file
		writing.writingFile("C:\\Users\\vito\\Desktop\\jsonrandom.txt", postRandom);
		
		//richiesta posting
		URL url=new URL("https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAN7MHVJMsdXcCEBqcMruXZBqZA1cqD1lD3C35woAG5JOZBkEMGA7aJcZBfj6ma9pgZBBhYZAzcRUhMYEZCtQJ20eyWUZBx20kVghInDdFnvLM8kZC9xLen6yE1D1Nb2cyG6IZBWsx75ZCCFehTV0HSH2c2GYDFSqTcmJ5CSw1pFY30yBdABdlOQa4rgmx93QkQSMwZDZD&message="+message+"&scheduled_publish_time="+newCreatedTime);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		System.out.println(con.getResponseMessage());
		
		//...da finire, problemi con connessione per posting, otterrò anche un id
		String indexPost="";
		
		//qualora la richiesta fosse accettata -> inserimento post in arraylist post
		post.add(cont, new post(newCreatedTime,indexPost,message));
		
		
		return post;
		}
		
	
	
	//calcola, se c'è necessità di cambiare orario per il posting, il nuovo orario per il post
	
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
	
	/*
	//calcola se la data scelta da noi è distante 4 ore da quella di nostro interesse
	
	public static boolean onlyDiff(String newTime, String lastTime) {
		Date newPostFormatted=null;
		Date lastPostFormatted=null;
		
		
		try {
			newPostFormatted = formatterFromPosting.parse(newTime);
			lastPostFormatted=formatterFromRecord.parse(lastTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((newPostFormatted.getTime()-lastPostFormatted.getTime())<14400000 &(newPostFormatted.getTime()-lastPostFormatted.getTime())>-14400000) {
		return true;}
		else return false;
	}
	
	
	//controlla se la data scelta da noi è più grande di quella analizzata
	
	public static boolean newIsGreater(String newTime, String lastTime) {
		Date newPostFormatted=null;
		Date lastPostFormatted=null;
		
		
		try {
			newPostFormatted = formatterFromPosting.parse(newTime);
			lastPostFormatted=formatterFromRecord.parse(lastTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((newPostFormatted.getTime()-lastPostFormatted.getTime())>0) {
		return true;}
		else return false;
	}
	
	//calcola se è una data accettabile per il posting, ovvero non dobbiamo postare indietro nel tempo
	
	public static boolean isGreaterThanCurrentTime(String newTime) {
		Date newPostFormatted=null;
		
		try {
			newPostFormatted = formatterFromPosting.parse(newTime);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newPostFormatted.getTime()-System.currentTimeMillis()<0) {
		return true;}
		else return false ;
		
	}
	*/
	}

