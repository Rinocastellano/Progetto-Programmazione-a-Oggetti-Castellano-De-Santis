package univpm.it.CastelDeSa.progettoOOP.model;
/**
 * classe descrizione oggetto Post
 * @author Rino Castellano
 * @author Matteo De Santis
 */
public class post {
	
	private String  created_time;
	private String message;
	private String id;
	
	/**
	 * classe costruttore
	 * @param c , data di pubblicazione post
	 * @param i , id del post
	 * @param m , contenuto del post
	 */
	public post(String c, String i, String m) {
		this.created_time=c;
		this.id=i;
		this.message=m;
	}
	/**
	 * getters/setters
	 */

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * override del metodo toString()
	 */
	@Override
	public String toString() {
		return "Message: " +this.getMessage()+"\nCreated time: "+this.getCreated_time()+"\n"+"id:"+this.getId();
	}

}