package Stany.st;

public class Stan {
	@Override
	public String toString() {
		return "nazwa stanu: " + nazwa + " podatek = " + podatek;
	}

	private String nazwa = "";
	private double podatek;

	public Stan(String linia) {
		String s = linia;
		String[] tokens = s.split(",");
		nazwa = tokens[0];
		podatek = Double.valueOf(tokens[1]);			 	
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public double getPodatek() {
		return podatek;
	}

	public void setPodatek(double podatek) {
		this.podatek = podatek;
	}

}
