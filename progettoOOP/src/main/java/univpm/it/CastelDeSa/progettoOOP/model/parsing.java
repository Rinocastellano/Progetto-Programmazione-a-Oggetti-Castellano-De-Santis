package univpm.it.CastelDeSa.progettoOOP.model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class parsing {
	 
    public static void start(urlReader url) throws Exception {
 

String str = url.read();
    			
    			
    	try {
			JSONObject obj = new JSONObject(str);
			List<post>posts=new ArrayList<post>();
			
			JSONArray t=obj.getJSONArray("data");
			for(int i=0; i<t.length();i++){
				JSONObject res = obj.getJSONArray("data").getJSONObject(i);
				ObjectMapper mapper= new ObjectMapper();
				mapper.findAndRegisterModules();
				post post = mapper.readValue(res.toString(),post.class);
				posts.add(post);
			}
			System.out.println(posts);
    } catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    	
    }
}

