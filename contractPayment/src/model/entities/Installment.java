package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Installment {
	
	private LocalDate dueDate;
	private Double amount;
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return fmt.format(dueDate) + " - " + String.format("%.2f", amount);
	}
	

}
