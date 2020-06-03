package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class reading {
	
	public static String readUrl(String url) throws IOException {

		String str=new String();
		URL url1=new URL(url);
		BufferedReader in= new BufferedReader(new InputStreamReader(url1.openStream()));
		String line;
		while((line=in.readLine())!=null) {
			str+=line;
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
