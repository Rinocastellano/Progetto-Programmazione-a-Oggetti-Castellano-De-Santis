package univpm.it.CastelDeSa.progettoOOP.app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
import univpm.it.CastelDeSa.progettoOOP.service.filterService;
import univpm.it.CastelDeSa.progettoOOP.service.postStorage;
import univpm.it.CastelDeSa.progettoOOP.service.statService;
import univpm.it.CastelDeSa.progettoOOP.service.temporizationPosting;
import univpm.it.CastelDeSa.progettoOOP.stat.statAvg;
import univpm.it.CastelDeSa.progettoOOP.stat.statCalculate;
import univpm.it.CastelDeSa.progettoOOP.stat.statMax;

@RestController
public class controller {
	
	@RequestMapping(value="post", method=RequestMethod.GET)
	public ArrayList<post> retrievePost(){
		return postStorage.getPost();
	}
	
	@RequestMapping(value="metadata", method=RequestMethod.GET)
	public ArrayList<metadata> retrieveMetadata(){
		return postStorage.getMetadatas();
	}
	
	@RequestMapping(value="schedule", method=RequestMethod.POST)
	public String schedulePost(@RequestBody post post) throws IOException, ParseException, URISyntaxException, badReqException, notFoundMethodException, fewStorageMessageException{
		return temporizationPosting.temporizzatedPosting(post, postStorage.posts);
	}
	
	@RequestMapping(value="statNum", method=RequestMethod.GET)
	public stat statNumPost(@RequestParam(value="statNum") String spec) throws commandStatException {
		statCalculate newStat= statService.statFormulation(spec, postStorage.posts);
		return newStat.doStat();
	}
	
	@RequestMapping(value="filter", method=RequestMethod.GET)
	public ArrayList<post> filter(@RequestParam(value="field") String command, @RequestParam(value="param1") ArrayList<String> param) throws commandStatException, betweenWrongValueException{
		filter newFilter= filterService.filterFormulation(command, postStorage.posts,param);
		return newFilter.doFilter();
	}
	
	/*@RequestMapping(value="filter",method=RequestMethod.POST)
	public stat statFiltered(@RequestParam(value="field") String command, @RequestBody stat statistic) throws commandStatException {
		ArrayList<post> postFiltered= filterService.filterFormulation(command, postStorage.posts).doFilter();
		statCalculate newStat= statService.statFormulation(statistic.getSpec(), postFiltered);
		return newStat.doStat();
		
	}*/

}
