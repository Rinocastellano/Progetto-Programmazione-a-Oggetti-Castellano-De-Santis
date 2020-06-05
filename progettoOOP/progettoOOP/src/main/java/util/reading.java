package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import univpm.it.CastelDeSa.progettoOOP.exceptions.*;
public class reading {
	
	public static String readUrl(String url) throws IOException, urlNotFoundException  {

		String str=new String();
		URL url1;
		try {
			url1 = new URL(url);
		
		
		BufferedReader in= new BufferedReader(new InputStreamReader(url1.openStream()));
		String line;
		while((line=in.readLine())!=null) {
			str+=line;
		}
		
} catch (MalformedURLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
}catch (UnknownHostException e ) {
	throw new urlNotFoundException(e);
	
}
		return str;
	}
	public static ArrayList<String> readFile(String file) throws IOException {
		ArrayList<String> post=new ArrayList<String>();
		BufferedReader in= new BufferedReader(new FileReader(file));
		String line;
		while((line=in.readLine())!=null) {
			post.add(new String(line));
		}
		return post;
	}

}
