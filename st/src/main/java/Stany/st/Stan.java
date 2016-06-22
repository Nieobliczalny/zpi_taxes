package Stany.st;

public class Stan {
	@Override
	public String toString() {
		return "nazwa stanu: " + nazwa + " podatekGlowny = " + inne.getPodatek();
	}

	private String nazwa = "";
	private DanePodatku inne;
	private DanePodatku groceries;
	private DanePodatku preparedFood;
	private DanePodatku prescriptionDrug;
	private DanePodatku nonPrescriptionDrug;
	private DanePodatku clothing;

	public Stan(String linia) {
		String s = linia;
		String[] tokens = s.split(",");
		nazwa = tokens[0];
		inne = new DanePodatku(tokens[1], null);
		groceries = new DanePodatku(tokens[2], inne);
		preparedFood = new DanePodatku(tokens[3], inne);
		prescriptionDrug = new DanePodatku(tokens[4], inne);
		nonPrescriptionDrug = new DanePodatku(tokens[5], inne);
		clothing = new DanePodatku(tokens[6], inne);
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public DanePodatku getPodatek(Produkt produkt) {
		String kategoria = produkt.getKategoria();
		if (kategoria.equalsIgnoreCase("groceries")) return groceries;
		if (kategoria.equalsIgnoreCase("prepared food")) return preparedFood;
		if (kategoria.equalsIgnoreCase("prescription drug")) return prescriptionDrug;
		if (kategoria.equalsIgnoreCase("non-prescription drug")) return nonPrescriptionDrug;
		if (kategoria.equalsIgnoreCase("clothing")) return clothing;
		return inne;
	}
}
