package univpm.it.CastelDeSa.progettoOOP;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import univpm.it.CastelDeSa.progettoOOP.model.parsing;
import univpm.it.CastelDeSa.progettoOOP.model.post;
import univpm.it.CastelDeSa.progettoOOP.model.reading;

@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) throws Exception {
		ArrayList<post> postRandom=parsing.start(reading.readFile("C:\\Users\\vito\\Desktop\\jsonrandom.txt"));
		ArrayList<post> post=parsing.start(reading.readUrl("https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD"));
		SpringApplication.run(ProgettoOopApplication.class, args);
	
	
	}
	

}
