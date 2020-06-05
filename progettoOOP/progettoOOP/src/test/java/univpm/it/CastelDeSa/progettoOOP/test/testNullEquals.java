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


class testNullEquals {
	
	 private reading read=new reading();
     private ArrayList<post>array= new ArrayList<post>();
     private parsing parsing=new parsing();
     private String urlget;
     private post post;
     private ArrayList<String> postRandom=new ArrayList<String>();
     
	@BeforeEach
	
	void setUp() throws Exception {
    urlget="https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD";    
	array=parsing.run(urlget);
	post=array.get(0);
	postRandom = read.readFile("C:\\Users\\Matteo\\Desktop\\maven\\test.txt");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
    @Test
    void test1() {
    	assertNotNull(array);
    	
    }
    @Test
    void test2() {
    	assertNotNull(post);
    	
    }
    @Test
    void test3() {
    	
    	assertNotNull(postRandom);
    }

}
