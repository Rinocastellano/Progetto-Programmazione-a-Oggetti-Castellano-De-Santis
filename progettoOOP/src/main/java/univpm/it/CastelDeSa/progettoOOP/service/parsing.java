package univpm.it.CastelDeSa.progettoOOP.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import univpm.it.CastelDeSa.progettoOOP.model.post;

public class parsing {
	String url;
	 static List<post>postatore=new ArrayList<post>();
	
	public  parsing(String url) throws MalformedURLException  {
		this.url=url;
		
		URL address = new URL(url);
		
		 Scanner scan;
		
			try {
				scan = new Scanner(address.openStream());
			

		  String str = new String();
		  while (scan.hasNext())
		      str += scan.nextLine();
		  scan.close();
		    			
		    			
		    			
		    	
					JSONObject obj = new JSONObject(str);
					
					
					JSONArray t=obj.getJSONArray("data");
					for(int i=0; i<t.length();i++){
						JSONObject res = obj.getJSONArray("data").getJSONObject(i);
						ObjectMapper mapper= new ObjectMapper();
						mapper.findAndRegisterModules();
						post post = mapper.readValue(res.toString(),post.class);
						postatore.add(post);
						
					}
					
					
					
					
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		
		
		
	}
	
	public static ArrayList<post> Getposts(){
		return (ArrayList<post>) postatore;
		
		
	}
	
	

}
