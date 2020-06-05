package univpm.it.CastelDeSa.progettoOOP.model;

public class metadata {
	private String name;
	private String meaning;
	private String type;
	
	public metadata(String n, String m, String t) {
		this.name=n;
		this.meaning=m;
		this.type=t;
	}

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
