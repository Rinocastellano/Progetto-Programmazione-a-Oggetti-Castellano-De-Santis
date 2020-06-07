package univpm.it.CastelDeSa.progettoOOP.model;

/**
 * classe descrizione oggetto statistica
 * @author Rino Castellano
 * @author Matteo De Santis
 */
public class StatNum extends Stat {
	private int avg;
	private int min;
	private int max;
	private int numTotalePost;
	/**
	 * costruttore di default preso dalla superclasse stat
	 */
	public StatNum() {
		super();
	}
	/**
	 * costruttore
	 * @param spec , specifica di statistica
	 * @param avg , calcolo numero medio di caratteri nel post
	 * @param min , calcolo numero minimo di caratteri nell'elenco dei post
	 * @param max , calcolo numero massimo di caratteri nell'elenco dei post
	 * @param n , numero dei post
	 */
	public StatNum(String spec,int avg, int min, int max, int n) {
		super(spec);
		this.avg=avg;
		this.max=max;
		this.min=min;
		this.numTotalePost=n;
	}
/**
 * getters/setters
 * 
 */
	public int getNumTotalePost() {
		return numTotalePost;
	}

	public void setNumTotalePost(int numTotalePost) {
		this.numTotalePost = numTotalePost;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	

}
