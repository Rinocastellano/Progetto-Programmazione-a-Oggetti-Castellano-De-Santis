package univpm.it.CastelDeSa.progettoOOP.service;

import java.io.IOException;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import univpm.it.CastelDeSa.progettoOOP.model.metadata;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import util.parsing;


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
    public static void start(String source) throws Exception {
    	
    	posts=parsing.run(source);
    	
    	
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

