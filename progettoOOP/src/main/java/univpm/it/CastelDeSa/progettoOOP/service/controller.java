package univpm.it.CastelDeSa.progettoOOP.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import univpm.it.CastelDeSa.progettoOOP.model.metadata;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.postStorage;

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
	public ArrayList<post> schedulePost(@RequestBody post post) throws IOException{
		return temporizationPosting.temporizzatedPosting(post, postStorage.posts);
	}
	

}
