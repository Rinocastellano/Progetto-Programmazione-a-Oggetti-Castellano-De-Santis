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
	 
    public static ArrayList<post> start(String source) throws Exception {
 

    	ArrayList<post> posts = new ArrayList<post>();
    	ArrayList<metadata> metadatas = new ArrayList<metadata>();
    			
    	//inserimento JSONObj in arraylist posts
    	try {
			JSONObject obj = new JSONObject(source);
			JSONArray t=obj.getJSONArray("data");
			for(int i=0; i<t.length();i++){
				JSONObject res = obj.getJSONArray("data").getJSONObject(i);
				ObjectMapper mapper= new ObjectMapper();
				mapper.findAndRegisterModules();
				posts.add(mapper.readValue(res.toString(),post.class));
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
    	
    	
    	//inserimento in metadatas
    	metadatas.add(new metadata("created_time","Time publishing post","String"));
    	metadatas.add(new metadata("message","content of post","String"));
    	metadatas.add(new metadata("id","post identificator","String"));
    	
    	return posts;
    }
}

