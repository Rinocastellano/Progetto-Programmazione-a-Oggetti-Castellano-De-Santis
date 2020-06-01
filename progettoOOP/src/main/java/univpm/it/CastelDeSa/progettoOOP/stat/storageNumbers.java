package univpm.it.CastelDeSa.progettoOOP.stat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import univpm.it.CastelDeSa.progettoOOP.*;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.service.parsing;
import univpm.it.CastelDeSa.progettoOOP.service.reading;


public class storageNumbers extends parsing {

	
	
	
	public storageNumbers(String url) throws MalformedURLException {
		super(url);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<post> getter=storageNumbers.Getposts();
			


   public ArrayList<String>Getnumbers(){
	   ArrayList<String>caratteri=new ArrayList<String>();
	   String str;
	   post p;
	  for(int i=0;i<getter.size();i++) {
		 p=getter.get(i);
		 str=p.getMessage();
		 caratteri.add(str);
		  
	  }
	  return caratteri;
	   
   }
	   
	   
	   
   }
	
	
	

	
	



