package univpm.it.CastelDeSa.progettoOOP.service;

import java.util.ArrayList;



import univpm.it.CastelDeSa.progettoOOP.model.Metadata;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.util.Parsing;


/**
 * 
 * Rapresenta la classe che gestisce i record di post e metadata
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
public class PostStorage {
	 
	public static  ArrayList<Post> posts = new ArrayList<Post>();
	static ArrayList<Metadata> metadatas = new ArrayList<Metadata>();
	
	
	/**
	 * Da una stringa formattata in JSON creo un ArrayList di tutti i post pubblicati.
	 * Inoltre creo l'ArrayList di metadata
	 * @param Json String estratta precedentemente da una lettura 
	 * @throws Exception
	 */
    public static void start(String source) throws Exception {
    	
    	posts=Parsing.run(source);
    	
    	
    	//inserimento in metadatas
    	metadatas.add(new Metadata("created_time","Time publishing post","String"));
    	metadatas.add(new Metadata("message","content of post","String"));
    	metadatas.add(new Metadata("id","post identificator","String"));
    }
    
    /** 
     * @return l'array con all'interno tutti i post
     */
    public static  ArrayList<Post> getPost(){
    	return posts;
    }
    
    /**
     * 
     * @return l'array con all'interno tutti i metadata
     */
    public static  ArrayList<Metadata> getMetadatas(){
    	return metadatas;
    }
}

