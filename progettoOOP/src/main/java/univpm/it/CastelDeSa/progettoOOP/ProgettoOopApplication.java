package univpm.it.CastelDeSa.progettoOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import univpm.it.CastelDeSa.progettoOOP.model.parsing;
import univpm.it.CastelDeSa.progettoOOP.model.urlReader;

@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) throws Exception {
		parsing.start(new urlReader("https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD"));
		SpringApplication.run(ProgettoOopApplication.class, args);
	}

}
