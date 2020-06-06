package univpm.it.CastelDeSa.progettoOOP.app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univpm.it.CastelDeSa.progettoOOP.exceptions.badReqException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.betweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.commandStatException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.fewStorageMessageException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.notFoundMethodException;
import univpm.it.CastelDeSa.progettoOOP.filter.*;
import univpm.it.CastelDeSa.progettoOOP.model.metadata;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.stat;
import univpm.it.CastelDeSa.progettoOOP.model.statNum;
import univpm.it.CastelDeSa.progettoOOP.service.andOrFilter;
import univpm.it.CastelDeSa.progettoOOP.service.filterService;
import univpm.it.CastelDeSa.progettoOOP.service.postStorage;
import univpm.it.CastelDeSa.progettoOOP.service.statService;
import univpm.it.CastelDeSa.progettoOOP.service.temporizationPosting;
import univpm.it.CastelDeSa.progettoOOP.stat.statAvg;
import univpm.it.CastelDeSa.progettoOOP.stat.statCalculate;
import univpm.it.CastelDeSa.progettoOOP.stat.statMax;

/**
 * classe di controller per richieste localhost:8080
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
@RestController
public class controller {
	
	/**
	 * l'elenco totale dei post pubblicati (non programmati) 
	 * @return elenco dei post con id, message, created_time
	 */
	@RequestMapping(value="post", method=RequestMethod.GET)
	public ArrayList<post> post(){
		return postStorage.getPost();
	}
	
	/**
	 * elenco totale del metadata
	 * @return elenco del metadata
	 */
	@RequestMapping(value="metadata", method=RequestMethod.GET)
	public ArrayList<metadata> metadata(){
		return postStorage.getMetadatas();
	}
	
	/**
	 * pubblicazione temporizzata di post con messaggio randomico preso da file di testo
	 * @param post , data e orario della pubblicazione temporizzata
	 * @return messaggio di conferma
	 * @throws IOException
	 * @throws ParseException
	 * @throws URISyntaxException
	 * @throws badReqException
	 * @throws notFoundMethodException
	 * @throws fewStorageMessageException
	 */
	@RequestMapping(value="schedule", method=RequestMethod.POST)
	public String schedulePost(@RequestBody post post) throws IOException, ParseException, URISyntaxException, badReqException, notFoundMethodException, fewStorageMessageException{
		return temporizationPosting.temporizzatedPosting(post, postStorage.posts);
	}
	
	/**
	 * calcolo statistica su elenco totale di post
	 * @param spec , specifica di statistica richiesta
	 * @return oggetto statistica con specifica di informazione
	 * @throws commandStatException
	 */
	@RequestMapping(value="statAllPost", method=RequestMethod.GET)
	public stat statNumPost(@RequestParam(value="statNum") String spec) throws commandStatException {
		statCalculate newStat= statService.statFormulation(spec, postStorage.posts);
		return newStat.doStat();
	}
	
	/**
	 * filtraggio su elenco totale dei post
	 * @param type , tipo di filtraggio (and, or , default)
	 * @param map , mappa con chiave i metodi di filtraggio e valori le stringhe di parametri
	 * di filtraggio
	 * @return elenco dei post filtrati
	 * @throws commandStatException
	 * @throws betweenWrongValueException
	 */
	@RequestMapping(value="filter", method=RequestMethod.POST)
	public ArrayList<post> filter(@RequestParam(value="type")String type,@RequestBody HashMap<String,ArrayList<String>> map) throws commandStatException, betweenWrongValueException{
			return andOrFilter.andOrFiltering(type, postStorage.posts, map);
	}
	
	/**
	 * calcolo statistica su elenco totale di post filtrati
	 * @param type , tipo di filtraggio (and, or , default)
	 * @param stat , stringa tipo di statistica
	 * @param map , mappa con chiave i metodi di filtraggio e valori le stringhe di parametri
	 * di filtraggio
	 * @return statistica su elenco di post filtrati
	 * @throws commandStatException
	 * @throws betweenWrongValueException
	 */
	@RequestMapping(value="filterWithStat",method=RequestMethod.POST)
	public stat statFiltered(@RequestParam(value="type") String type,@RequestParam(value="stat") String stat, @RequestBody HashMap<String,ArrayList<String>> map) throws commandStatException, betweenWrongValueException {
		ArrayList<post> postFiltered=andOrFilter.andOrFiltering(type, postStorage.posts, map);
		statCalculate newStat= statService.statFormulation(stat, postFiltered);
		return newStat.doStat();
		
	}

}
