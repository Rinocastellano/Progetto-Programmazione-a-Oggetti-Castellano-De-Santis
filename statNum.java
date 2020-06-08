package univpm.it.CastelDeSa.progettoOOP.model;

public class statNum extends stat {
	private int avg;
	private int min;
	private int max;
	private int numTotalePost;
	
	public statNum() {
		super();
	}
	
	public statNum(String spec,int avg, int min, int max, int n) {
		super(spec);
		this.avg=avg;
		this.max=max;
		this.min=min;
		this.numTotalePost=n;
	}

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
