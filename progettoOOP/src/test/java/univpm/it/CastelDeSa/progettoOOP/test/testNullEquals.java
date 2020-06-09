package univpm.it.CastelDeSa.progettoOOP.test;

import univpm.it.CastelDeSa.progettoOOP.model.Post;
import univpm.it.CastelDeSa.progettoOOP.util.Parsing;
import univpm.it.CastelDeSa.progettoOOP.util.Reading;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * classe di test 
 * @author Castellano Rino
 * @author De Santis Matteo
 *
 */
class testNullEquals {

	 private Reading read=new Reading();
     private ArrayList<Post>array= new ArrayList<Post>();
     private Parsing parsing=new Parsing();
     private String urlget;
     private Post post;
     private ArrayList<String> postRandom=new ArrayList<String>();

	@BeforeEach
	void setUp() throws Exception {
    urlget="https://graph.facebook.com/107920467600716/feed?access_token=EAAkZCLlHE3QkBAAKWPfQkzb5q7IegjC70zpPwgDcurkFBX2NYwIeZBeuZAZAs2zVqcjZBPcmqLWuY6GFUCGFxjpcZAdbLTIi3Wl3OfIMuu0yWqFYYwywwYen0sfjK3ZCVGnAZCj8mt7IfVQlJZCrKtqq8AImsuGMuhZBOPigC5EyNTqAZDZD";    
	array=parsing.run(urlget);
	post=array.get(0);
	postRandom = read.readFile("C:\\Users\\vito\\Desktop\\jsonrandom.txt");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	/**
	 * test sul parsing affinchè non ritorni un val nullo
	 */
    @Test
    void test1() {
    	assertNotNull(array);
    }
    /**
     * test sulla verifica dell'esistenza del post
     */
    @Test
    void test2() {
    	assertNotNull(post);
    }
    /**
     * lettura file funzionante
     */
    @Test
    void test3() {

    	assertNotNull(postRandom);
    }

}