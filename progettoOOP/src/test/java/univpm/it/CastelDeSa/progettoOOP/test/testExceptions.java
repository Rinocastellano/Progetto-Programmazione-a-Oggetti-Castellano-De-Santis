package univpm.it.CastelDeSa.progettoOOP.test;

import univpm.it.CastelDeSa.progettoOOP.exceptions.BadReqException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.BetweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.CommandException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.UrlNotFoundException;
import univpm.it.CastelDeSa.progettoOOP.filter.FilterBt;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.service.FilterService;
import univpm.it.CastelDeSa.progettoOOP.service.StatService;
import univpm.it.CastelDeSa.progettoOOP.util.HttpRequest;
import univpm.it.CastelDeSa.progettoOOP.util.Parsing;
import univpm.it.CastelDeSa.progettoOOP.util.Reading;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * classe di test sulle eccezioni
 * @author Castellano Rino
 * @author De Santis Matteo
 *
 */
class testExceptions {

     private ArrayList<Post>array= new ArrayList<Post>();
     private static Parsing parsing=new Parsing();
     private String urlget;
     private String urlpost;
     private ArrayList<String>param= new ArrayList<String>();
     private String created_time;
     private FilterBt between;
     private final String invalidUrl ="http://uhiuh";
     private final String invalidcommand1 ="weqweqweqw";
     private final String invalidcommand2 ="qeqweqweqe";

	@BeforeEach

	void setUp() throws Exception {
    urlget="https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD";    
	urlpost="https://graph.facebook.com/107920467600716/feed?message=AC/DC&access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD";
    array=parsing.run(urlget);
	param.add("1000");
	param.add("10");
	created_time="null";
	between=new FilterBt(array,param);


	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * verifica del funzionamento eccezione CommandException, usato nel StatService, FilterService
	 */
	@Test 
	void test1(){
		assertThrows(CommandException.class, ()->StatService.statFormulation(invalidcommand1,array));
		assertThrows(CommandException.class, ()->FilterService.filterFormulation(invalidcommand2, array, param));
	}
	/**
	 * verifica del funzionamento eccezione UrlNotFoundException usato nel Reading
	 */
	@Test
	void test2() {

		assertThrows(UrlNotFoundException.class, ()->Reading.readUrl(invalidUrl));
	}
	/**
	 * verifica del funzionamento eccezione BadReqException usato nel HttpRequest
	 */
	@Test
	void test3() {
		assertThrows(BadReqException.class, ()->HttpRequest.postRequest(urlget, created_time));
	}
	/**
	 * verifica del funzionamento eccezione BetweenWrongValueException usato nel Between filter
	 */
	@Test
	void test4() {
	assertThrows(BetweenWrongValueException.class, ()->between.doFilter());

	}
}