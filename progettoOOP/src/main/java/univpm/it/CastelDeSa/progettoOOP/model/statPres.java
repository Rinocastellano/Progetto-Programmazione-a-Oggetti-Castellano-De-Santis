package univpm.it.CastelDeSa.progettoOOP.model;

/**
 * classe estensione di stat, contenente statistiche che vanno al di fuori del calcolo matematico,
 * come presenza di file multimediali
 * @author Castellano Rino
 * @author Matteo De Santis
 *
 */
public class statPres extends stat{
	private boolean pres;
	private int numPost;
	/**
	 * costruttore
	 * @param pres , presenza o meno di una determinata specifica
	 * @param spec , specifica di statistica
	 * @param numPost , numero di post che rispettano determinata specifica
	 */
	public statPres(boolean pres, String spec, int numPost) {
		super(spec);
		this.pres=pres;
		this.numPost=numPost;
	}

	public statPres() {
		super();
	}

	public boolean getPres() {
		return pres;
	}

	public void setPres(boolean pres) {
		this.pres = pres;
	}

	public int getNumPost() {
		return numPost;
	}

	public void setNumPost(int numPost) {
		this.numPost = numPost;
	}
	
	

}
