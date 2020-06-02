package univpm.it.CastelDeSa.progettoOOP.model;

public class statPres extends stat{
	private int pres;
	
	public statPres(int pres, String spec) {
		super(spec);
		this.pres=pres;
	}

	public int getPres() {
		return pres;
	}

	public void setPres(int pres) {
		this.pres = pres;
	}
	
	

}
