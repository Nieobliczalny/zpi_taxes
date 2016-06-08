package Stany.st;

public class DanePodatku {
	private double limit;
	private double podatek;
	public DanePodatku(double limit, double podatek) {
		super();
		this.limit = limit;
		this.podatek = podatek;
	}
	public DanePodatku(String s, DanePodatku baza)
	{
		super();
		if (s.charAt(0) == '$')
		{
			this.limit = Double.valueOf(s.substring(1));
			this.podatek = baza.getPodatek();
		}
		else
		{
			this.limit = 0;
			this.podatek = Double.valueOf(s.substring(0, s.length() - 1));
		}
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public double getPodatek() {
		return podatek;
	}
	public void setPodatek(double podatek) {
		this.podatek = podatek;
	}
}
