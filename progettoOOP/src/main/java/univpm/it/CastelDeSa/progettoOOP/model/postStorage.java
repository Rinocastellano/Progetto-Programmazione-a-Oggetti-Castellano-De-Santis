package univpm.it.CastelDeSa.progettoOOP.model;

import java.io.IOException;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 * Rapresenta la classe che gestisce i record di post e metadata
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class postStorage {
	 
	public static  ArrayList<post> posts = new ArrayList<post>();
	static ArrayList<metadata> metadatas = new ArrayList<metadata>();
	
	
	/**
	 * Da una stringa formattata in JSON creo un ArrayList di tutti i post pubblicati.
	 * Inoltre creo l'ArrayList di metadata
	 * @param Json String estratta precedentemente da una lettura 
	 * @throws Exception
	 */
    public static  void start(String source) throws Exception {

    	
    			
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
    }
    
    /** 
     * @return l'array con all'interno tutti i post
     */
    public static  ArrayList<post> getPost(){
    	return posts;
    }
    
    /**
     * 
     * @return l'array con all'interno tutti i metadata
     */
    public static  ArrayList<metadata> getMetadatas(){
    	return metadatas;
    }
}

