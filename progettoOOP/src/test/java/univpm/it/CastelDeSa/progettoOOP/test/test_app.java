package univpm.it.CastelDeSa.progettoOOP.test;
import  univpm.it.CastelDeSa.progettoOOP.*;
import univpm.it.CastelDeSa.progettoOOP.exceptions.commandStatException;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.service.statService;
import univpm.it.CastelDeSa.progettoOOP.stat.statCalc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class test_app {
	
	 private statService stat_test= new statService();
	
     private ArrayList<post>array= new ArrayList<post>();
    
		 private post post;

	@BeforeEach
	void setUp() throws Exception {
		 String created_time="2020-05-31T13:53:40+0000";
			String id="107920467600716_118630979862998";
			String message="Freddie Mercury";
			  post= new post(created_time,id,message);
		array.add(0, post);
	   //stat_test.statFormulation("Max",array);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test 
	void test(){
		assertThrows(ClassNotFoundException.class, ()->stat_test.statFormulation("erwerer",array));
	}
}
