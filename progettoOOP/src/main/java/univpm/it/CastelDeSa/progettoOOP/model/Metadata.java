package univpm.it.CastelDeSa.progettoOOP.model;
/**
 * classe descrizione dell'oggetto Metadata riguardante la classe Post
 * @author Rino Castellano
 * @author Matteo De Santis
 */
public class Metadata {
	private String name;
	private String meaning;
	private String type;
	
	/**
	 * classe costruttore
	 * @param n , nome della caratteristica
	 * @param m , significato del contenuto della caratteristica
	 * @param t , tipo di formattazione
	 */
	public Metadata(String n, String m, String t) {
		this.name=n;
		this.meaning=m;
		this.type=t;
	}
/**
 * getters/setters
 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.getName()+": "+this.getMeaning()+". "+this.getType()+"\n";
	}

}
