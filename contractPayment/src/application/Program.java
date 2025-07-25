package application;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double contractValue = sc.nextDouble();
		Contract contract = new Contract(number, date, contractValue);
		
		System.out.print("Entre com o número de parcelas: ");
		int numberInstallments = sc.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, numberInstallments);
		
		System.out.println("PARCELAS: ");
		
		for(Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		}
		catch(DateTimeException e) {
			
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
