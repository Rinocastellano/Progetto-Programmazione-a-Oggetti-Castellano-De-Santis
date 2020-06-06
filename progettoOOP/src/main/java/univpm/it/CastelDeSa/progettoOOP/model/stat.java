package univpm.it.CastelDeSa.progettoOOP.model;

import java.net.MalformedURLException;
import java.util.ArrayList;



/**
 * classe statistica generica, contiene solo la specifica
 * @param spec, specifica
 */
public class stat {
	
	String spec;
	public stat() {
	}
	public stat(String s) {
		this.spec=s;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

}	 
