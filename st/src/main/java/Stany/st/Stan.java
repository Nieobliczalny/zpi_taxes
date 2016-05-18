package Stany.st;

import java.util.Scanner;

public class Stan 
{
	private String nazwa = null;	
	private int podatek = 0;
	
	public Stan(String linia) 
	{
		Scanner s = new Scanner(linia);
		nazwa = s.next();
		podatek = s.nextInt();
		s.close();
		
	}	
	
	
	@Override
	public String toString() {
		return "Stan [nazwa=" + nazwa + ", podatek=" + podatek + "]";
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getPodatek() {
		return podatek;
	}

	public void setPodatek(int podatek) {
		this.podatek = podatek;
	}
	
	
	
	
	
}
