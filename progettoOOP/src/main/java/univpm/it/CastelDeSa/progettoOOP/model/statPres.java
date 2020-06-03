package univpm.it.CastelDeSa.progettoOOP.model;

/**
 * classe estensione di stat, contenente statistiche che vanno al di fuori del calcolo matematico,
 * come presenza di file multimediali
 * @author Castellano Rino
 *
 */
public class statPres extends stat{
	private boolean pres;
	
	public statPres(boolean pres, String spec) {
		super(spec);
		this.pres=pres;
	}

	public boolean getPres() {
		return pres;
	}

	public void setPres(boolean pres) {
		this.pres = pres;
	}
	
	

}
