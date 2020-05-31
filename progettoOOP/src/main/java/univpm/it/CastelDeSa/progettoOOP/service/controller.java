package univpm.it.CastelDeSa.progettoOOP.service;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import univpm.it.CastelDeSa.progettoOOP.model.post;

@RestController
public class controller {
	
	@RequestMapping(value="post", method=RequestMethod.GET)
	public ArrayList<post> retrievePost(){
		return parsing.
		
	}

}
