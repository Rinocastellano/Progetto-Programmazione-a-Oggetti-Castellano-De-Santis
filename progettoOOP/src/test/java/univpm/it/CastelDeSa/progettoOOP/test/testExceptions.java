package univpm.it.CastelDeSa.progettoOOP.test;
import  univpm.it.CastelDeSa.progettoOOP.*;
import univpm.it.CastelDeSa.progettoOOP.exceptions.badReqException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.betweenWrongValueException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.commandStatException;
import univpm.it.CastelDeSa.progettoOOP.exceptions.urlNotFoundException;
import univpm.it.CastelDeSa.progettoOOP.filter.filterBt;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.service.filterService;
import univpm.it.CastelDeSa.progettoOOP.service.statService;
import univpm.it.CastelDeSa.progettoOOP.stat.statCalculate;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.*;


class testExceptions {

     private ArrayList<post>array= new ArrayList<post>();
     private static parsing parsing=new parsing();
     private String urlget;
     private String urlpost;
     private ArrayList<String>param= new ArrayList<String>();
     private String created_time;
     private filterBt between;  
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
	between=new filterBt(array,param);


	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test 
	void test1(){
		assertThrows(commandStatException.class, ()->statService.statFormulation(invalidcommand1,array));
		assertThrows(commandStatException.class, ()->filterService.filterFormulation(invalidcommand2, array, param));
	}
	@Test
	void test2() {

		assertThrows(urlNotFoundException.class, ()->reading.readUrl(invalidUrl));


	}
	@Test
	void test3() {

		assertThrows(badReqException.class, ()->httpRequest.postRequest(urlpost, created_time));


	}
	@Test
	void test4() {
	assertThrows(betweenWrongValueException.class, ()->between.doFilter());

	}
}