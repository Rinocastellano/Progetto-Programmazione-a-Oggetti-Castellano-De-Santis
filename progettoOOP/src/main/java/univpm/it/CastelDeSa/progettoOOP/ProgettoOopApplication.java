package univpm.it.CastelDeSa.progettoOOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import univpm.it.CastelDeSa.progettoOOP.model.parsing;
import univpm.it.CastelDeSa.progettoOOP.model.urlReader;

@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) {
		parsing.start(new urlReader("https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAHMX4UNhZAC1mZAkGrY1qEe49YHtiyvRyZAmX3LypCipPWQzPhAl3Bxu3VE6MSA3P6m7v4qX0BthsWMvjpbtVzqt5dAvjEqGhcGA5uRbxmgj0GrurkeBIJGX8GxUgl9F8hpGDjcMZAc3MJrJV6g8daggQFlZAcxTDWASJHkCHm2JC1sBOCZCgZD"));
		SpringApplication.run(ProgettoOopApplication.class, args);
	}

}
