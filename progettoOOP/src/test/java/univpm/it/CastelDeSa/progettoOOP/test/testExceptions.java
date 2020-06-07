package univpm.it.CastelDeSa.progettoOOP.test;
import  univpm.it.CastelDeSa.progettoOOP.*;
import univpm.it.CastelDeSa.progettoOOP.exceptions.BadReqException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.BetweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.CommandException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.UrlNotFoundException;
import univpm.it.CastelDeSa.progettoOOP.filter.FilterBt;
import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.service.FilterService;
import univpm.it.CastelDeSa.progettoOOP.service.StatService;
import univpm.it.CastelDeSa.progettoOOP.stat.StatCalculate;
import univpm.it.CastelDeSa.progettoOOP.util.HttpRequest;
import univpm.it.CastelDeSa.progettoOOP.util.Parsing;
import univpm.it.CastelDeSa.progettoOOP.util.Reading;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



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
	created_time="2020-05-31T13:53:40+0000";
	between=new FilterBt(array,param);


	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test 
	void test1(){
		assertThrows(CommandException.class, ()->StatService.statFormulation(invalidcommand1,array));
		assertThrows(CommandException.class, ()->FilterService.filterFormulation(invalidcommand2, array, param));
	}
	@Test
	void test2() {

		assertThrows(UrlNotFoundException.class, ()->Reading.readUrl(invalidUrl));


	}
	@Test
	void test3() {

		assertThrows(BadReqException.class, ()->HttpRequest.postRequest(urlpost, created_time));


	}
	@Test
	void test4() {
	assertThrows(BetweenWrongValueException.class, ()->between.doFilter());

	}
}