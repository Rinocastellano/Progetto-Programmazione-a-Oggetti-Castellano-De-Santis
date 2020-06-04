package util;

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

	public static ArrayList<post> run(String url) throws MalformedURLException, JsonMappingException, JsonProcessingException, JSONException  {
		ArrayList<post>postatore=new ArrayList<post>();			
		String str = null;
		try {
			str = reading.readUrl(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject(str);


		JSONArray t=obj.getJSONArray("data");
		for(int i=0; i<t.length();i++){
			JSONObject res = obj.getJSONArray("data").getJSONObject(i);
			ObjectMapper mapper= new ObjectMapper();
			mapper.findAndRegisterModules();
			post post = mapper.readValue(res.toString(),post.class);
			postatore.add(post);
		}
		return postatore;
	}


}