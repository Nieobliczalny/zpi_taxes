package Stany.st;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class KategoriaTest {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> temp = new ArrayList<String>();
		temp=Kategoria.readProductsFromCatogorie("Groceries");
		System.out.println("kategoria: groceries");
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
			
		}	
		System.out.println(" ");

		
		ArrayList<String> temp2 = new ArrayList<String>();
		temp=Kategoria.readProductsFromCatogorie("Prepared food");
		System.out.println("kategoria: prepared food");
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
			
		}		System.out.println(" ");

		ArrayList<String> temp3 = new ArrayList<String>();
		temp=Kategoria.readProductsFromCatogorie("Other");
		System.out.println("kategoria: inne");
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
			
		}		System.out.println(" ");

		
		ArrayList<String> temp4 = new ArrayList<String>();
		temp=Kategoria.readProductsFromCatogorie("Prescription drug");
		System.out.println("kategoria: leki na recepte");
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
			
		}		System.out.println(" ");

		ArrayList<String> temp5 = new ArrayList<String>();
		temp=Kategoria.readProductsFromCatogorie("Non-prescription drug");
		System.out.println("kategoria: leki bez recepty");
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
			
		}		System.out.println(" ");

		
		ArrayList<String> temp6 = new ArrayList<String>();
		temp=Kategoria.readProductsFromCatogorie("Clothing");
		System.out.println("kategoria: Clothing");
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
			
		}		System.out.println(" ");

		
		ArrayList<String> temp7 = new ArrayList<String>();
		temp=Kategoria.readProductsFromCatogorie("clothig");
		System.out.println("kategoria: nieprawidlowa");
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
			
		}		System.out.println(" ");

		
		
		
		
		
	}
	

}
