package univpm.it.CastelDeSa.progettoOOP.model;


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

public class temporizationPosting {
	public static void main(String args[]) throws IOException {
		String message="Ciao è un post super programmato";
		String newPost="2020-05-30T15:38:50";
		String last="2020-05-21T15:40:50+0000";
		String url=null;
		Date newPostFormatted=null;
		Date lastPostFormatted=null;
		SimpleDateFormat formatterFromPosting= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat formatterFromRecord= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS");
		
		//trasformiamo le stringhe in date per fare i calcoli
		try {
			newPostFormatted = formatterFromPosting.parse(newPost);
			lastPostFormatted=formatterFromRecord.parse(last);
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
			 newPost=formatterFromPosting.format(newPostFormatted);
		}
		url="https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAN7MHVJMsdXcCEBqcMruXZBqZA1cqD1lD3C35woAG5JOZBkEMGA7aJcZBfj6ma9pgZBBhYZAzcRUhMYEZCtQJ20eyWUZBx20kVghInDdFnvLM8kZC9xLen6yE1D1Nb2cyG6IZBWsx75ZCCFehTV0HSH2c2GYDFSqTcmJ5CSw1pFY30yBdABdlOQa4rgmx93QkQSMwZDZD&message="+message+"&scheduled_publish_time="+newPost;
		
		//lettura da file//

		
		ArrayList<post> postRandom=parsing.start(reading.readFile("C:\\Users\\vito\\Desktop\\jsonrandom.txt"));

		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String testo;
			String[] token;
			List<String> elenco = new ArrayList<String>();
			while ((testo = in.readLine()) != null) {

				token = testo.split("\n");

				for (String tokens : token) {
					System.out.println(tokens);

					elenco.add(tokens);
				}
			}

			// randomizzazione dei post//
			int n = elenco.size();
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
		}
		
		
		
		
		
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

