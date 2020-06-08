package univpm.it.CastelDeSa.progettoOOP.app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import univpm.it.CastelDeSa.progettoOOP.exceptions.BadReqException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.BetweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.CommandException;

import univpm.it.CastelDeSa.progettoOOP.exceptions.FewStorageMessageException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.NotFoundMethodException;
import univpm.it.CastelDeSa.progettoOOP.model.Metadata;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.model.Stat;
import univpm.it.CastelDeSa.progettoOOP.service.AndOrFilter;
import univpm.it.CastelDeSa.progettoOOP.service.PostStorage;
import univpm.it.CastelDeSa.progettoOOP.service.StatService;
import univpm.it.CastelDeSa.progettoOOP.service.TemporizationPosting;
import univpm.it.CastelDeSa.progettoOOP.stat.StatCalculate;

/**
 * classe di controller per richieste localhost:8080
 * @author Rino Castellano
 * @author Matteo De Santis
 *
 */
@RestController
public class Controller {
	
	/**
	 * l'elenco totale dei post pubblicati (non programmati) 
	 * @return elenco dei post con id, message, created_time
	 */
	@RequestMapping(value="post", method=RequestMethod.GET)
	public ArrayList<Post> post(){
		return PostStorage.getPost();
	}
	
	/**
	 * elenco totale del metadata
	 * @return elenco del metadata
	 */
	@RequestMapping(value="metadata", method=RequestMethod.GET)
	public ArrayList<Metadata> metadata(){
		return PostStorage.getMetadatas();
	}
	
	/**
	 * pubblicazione temporizzata di post con messaggio randomico preso da file di testo
	 * @param post , data e orario della pubblicazione temporizzata
	 * @return messaggio di conferma
	 * @throws IOException
	 * @throws ParseException
	 * @throws URISyntaxException
	 * @throws BadReqException
	 * @throws NotFoundMethodException
	 * @throws FewStorageMessageException
	 */
	@RequestMapping(value="schedule", method=RequestMethod.POST)
	public String schedulePost(@RequestBody String date) throws IOException, ParseException, URISyntaxException, BadReqException, NotFoundMethodException, FewStorageMessageException{
		return TemporizationPosting.temporizzatedPosting(date, PostStorage.posts);
	}
	
	/**
	 * calcolo statistica su elenco totale di post
	 * @param spec , specifica di statistica richiesta
	 * @return oggetto statistica con specifica di informazione
	 * @throws commandStatException
	 */
	@RequestMapping(value="stat", method=RequestMethod.GET)
	public Stat stat(@RequestParam(value="type") String spec) throws CommandException {
		StatCalculate newStat= StatService.statFormulation(spec, PostStorage.posts);
		return newStat.doStat();
	}
	
	/**
	 * filtraggio su elenco totale dei post
	 * @param type , tipo di filtraggio (and, or , default)
	 * @param map , mappa con chiave i metodi di filtraggio e valori le stringhe di parametri
	 * di filtraggio
	 * @return elenco dei post filtrati
	 * @throws commandStatException
	 * @throws BetweenWrongValueException
	 */
	
	@RequestMapping(value="filter", method=RequestMethod.POST)
	public ArrayList<Post> filter(@RequestParam(value="type")String type,@RequestBody HashMap<String,ArrayList<String>> map) throws CommandException, BetweenWrongValueException{	
		return AndOrFilter.andOrFiltering(type, PostStorage.posts, map);
	}
	
	/**
	 * calcolo statistica su elenco totale di post filtrati
	 * @param type , tipo di filtraggio (and, or , default)
	 * @param stat , stringa tipo di statistica
	 * @param map , mappa con chiave i metodi di filtraggio e valori le stringhe di parametri
	 * di filtraggio
	 * @return statistica su elenco di post filtrati
	 * @throws commandStatException
	 * @throws BetweenWrongValueException
	 */
	@RequestMapping(value="statFiltered",method=RequestMethod.POST)
	public Stat statFiltered(@RequestParam(value="type") String type,@RequestParam(value="stat") String stat, @RequestBody HashMap<String,ArrayList<String>> map) throws CommandException, BetweenWrongValueException {
		ArrayList<Post> postFiltered=AndOrFilter.andOrFiltering(type, PostStorage.posts, map);
		StatCalculate newStat= StatService.statFormulation(stat, postFiltered);
		return newStat.doStat();
		
	}

}
