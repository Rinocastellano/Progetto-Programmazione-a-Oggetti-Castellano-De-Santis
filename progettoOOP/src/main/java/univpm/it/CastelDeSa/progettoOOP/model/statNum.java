package univpm.it.CastelDeSa.progettoOOP.model;

public class statNum extends stat {
	private int avg;
	private int min;
	private int max;
	
	
	public statNum(String spec,int avg, int min, int max) {
		super(spec);
		this.avg=avg;
		this.max=max;
		this.min=min;
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
