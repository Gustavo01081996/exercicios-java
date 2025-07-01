package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Person> people = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int quantity = sc.nextInt();
		
		for(int i = 0; i < quantity; i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().toLowerCase().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if(type == 'c') {
				System.out.print("Number of employees: ");
				double numberEmployees = sc.nextDouble();
				people.add(new LegalPerson(name, annualIncome, numberEmployees));
			}
			else {
				System.out.print("Health expendictures: ");
				double healthExpendictures = sc.nextDouble();
				people.add(new NaturalPerson(name, annualIncome, healthExpendictures));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double sum = 0;
		
		for(Person person : people) {
			System.out.println(person);
			sum += person.tax();
		}
		
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));
		
		sc.close();

	}

}
