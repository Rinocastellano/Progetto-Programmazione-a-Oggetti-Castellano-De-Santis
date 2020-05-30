package univpm.it.CastelDeSa.progettoOOP.model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class urlReader {
	private String url;
	
	public urlReader(String url) {
		this.url=url;
	}
	
	public String read() throws Exception{
		String string= new String();
		URL u=new URL(this.url);
		BufferedReader in= new BufferedReader(new InputStreamReader(u.openStream()));
		String line;
		while((line=in.readLine())!=null) {
			string+=line;
		}
		return string;
	}

}
