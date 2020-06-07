package univpm.it.CastelDeSa.progettoOOP.util;

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

import univpm.it.CastelDeSa.progettoOOP.exceptions.UrlNotFoundException;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
/**
* classe di parsing dato una stringa url sorgente
* @author Castellano Rino
* @author Matteo De Santis
*
*/
public class Parsing {

	/**
	 * metodo di parsing per la creazione di arraylist di post
	 * @param url , url da dove otteniamo la stringa per il parsing, alla quale si effettua una richiesta get
	 * @return arraylist di post, l'elenco da utilizzare
	 * @throws MalformedURLException
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws JSONException
	 * @throws UrlNotFoundException
	 */
	public static ArrayList<Post> run(String url) throws MalformedURLException, JsonMappingException, JsonProcessingException, JSONException, UrlNotFoundException  {
		ArrayList<Post>postatore=new ArrayList<Post>();			
		String str = null;
		try {
			str = Reading.readUrl(url);
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
			Post post = mapper.readValue(res.toString(),Post.class);
			postatore.add(post);
		}
		return postatore;
	}


}