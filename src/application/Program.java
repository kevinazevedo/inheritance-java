package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
	
public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = scan.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = scan.next().charAt(0);
			System.out.print("Name: ");
			scan.nextLine();
			String name = scan.nextLine();
			System.out.print("Price: ");
			Double price = scan.nextDouble();
			
			if (resp == 'c' || resp == 'C') {
				list.add(new Product(name, price));
			}
			else if (resp == 'u' || resp == 'U') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(scan.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, manufactureDate));
			}
			else if (resp == 'i' || resp == 'I') {
				System.out.print("Custom fee: ");
				Double customFee = scan.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
			}			
		}
		
		System.out.println("\nPRICE TAGS:");
		
		for (Product p : list) {
			System.out.println(p.priceTag());
		}

		scan.close();
	}
}
