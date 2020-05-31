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

public class temporizationPosting {
	
	public ArrayList<post> temporizzatedPosting(int year, int month, int day, int hour, int minute, int second) throws IOException {
		ArrayList<post> post= new ArrayList<post>(); //lo toglieremo, abbiamo già post
		
		String newCreatedTime=year+"-"+month+"-"+day+"T"+hour+":"+minute+":"+second;	
		post lastPost=post.get(0);
		String lastCreatedTime=lastPost.getCreated_time();//lo toglieremo
		String url=null;
		Date newPostFormatted=null;
		Date lastPostFormatted=null;
		SimpleDateFormat formatterFromPosting= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat formatterFromRecord= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS");
		
		//trasformiamo le stringhe in date per fare i calcoli
		try {
			newPostFormatted = formatterFromPosting.parse(newCreatedTime);
			lastPostFormatted=formatterFromRecord.parse(lastCreatedTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//condizione per cambiare o meno l'orario di posting
		if((newPostFormatted.getTime()-lastPostFormatted.getTime())<0) {
			 Calendar calendar= Calendar.getInstance();
			 calendar.setTime(lastPostFormatted);
			 calendar.add(Calendar.HOUR_OF_DAY, 4);
			 newPostFormatted=calendar.getTime();
			 newCreatedTime=formatterFromPosting.format(newPostFormatted);
		}

		
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
		url="https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAN7MHVJMsdXcCEBqcMruXZBqZA1cqD1lD3C35woAG5JOZBkEMGA7aJcZBfj6ma9pgZBBhYZAzcRUhMYEZCtQJ20eyWUZBx20kVghInDdFnvLM8kZC9xLen6yE1D1Nb2cyG6IZBWsx75ZCCFehTV0HSH2c2GYDFSqTcmJ5CSw1pFY30yBdABdlOQa4rgmx93QkQSMwZDZD&message="+message+"&scheduled_publish_time="+newCreatedTime;
		//...da finire, problemi con connessione per posting, otterrò anche un id
		String indexPost="";
		
		//qualora la richiesta fosse accettata -> inserimento post in arraylist post
		post.add(0, new post(newCreatedTime,indexPost,message));
		
		
		return post;
		
			// randomizzazione dei post//
			/*int n = elenco.size();
			Vector<Integer> numeri = new Vector<Integer>();
			Random random = new Random();
			int caso = random.nextInt(n);

			for (int l = 0; l < elenco.size(); l++) {

				do {

					caso = random.nextInt(n);

				} while (numeri.contains(caso));

				numeri.add(caso);

				System.out.println(caso);

				String message = elenco.get(caso);

				URL url = new URL(
						"https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAN7MHVJMsdXcCEBqcMruXZBqZA1cqD1lD3C35woAG5JOZBkEMGA7aJcZBfj6ma9pgZBBhYZAzcRUhMYEZCtQJ20eyWUZBx20kVghInDdFnvLM8kZC9xLen6yE1D1Nb2cyG6IZBWsx75ZCCFehTV0HSH2c2GYDFSqTcmJ5CSw1pFY30yBdABdlOQa4rgmx93QkQSMwZDZD&message="
								+ message + "&scheduled_publish_time=" + newPost);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
		
		/*
		URL u=null;
		HttpURLConnection con=null;
		String data=null;
		try {
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			//con.connect();
			con.setRequestMethod("POST");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String i= ((HttpURLConnection) con).getResponseMessage();
		System.out.println(newPost+"\n"+i);
			*/
			
		}
		
		
	}

