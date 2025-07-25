package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> listProducts = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();
		
		for(int i = 0; i < numberProducts; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().toLowerCase().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(type == 'c') {
				listProducts.add(new Product(name, price));
			}
			else if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				listProducts.add(new UsedProduct(name, price, date));
			}
			else {
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				listProducts.add(new ImportedProduct(name, price, fee));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for(Product product : listProducts) {
			System.out.println(product.priceTag());
		}
		
		sc.close();

	}

}
