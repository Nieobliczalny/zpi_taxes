package Stany.st;

public class Produkt {
	@Override
	public String toString() {
		return "nazwa produktu: " + nazwa + " cena = " + cena + " kategoria = " + kategoria;
	}

	private String nazwa = "";
	private double cena;
	private String kategoria;

	public Produkt(String linia) {
		String s = linia;
		String[] tokens = s.split(",");
		nazwa = tokens[0];
		cena = Double.valueOf(tokens[1]);
		kategoria = tokens[2];
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double _cena) {
		this.cena = _cena;
	}

}

