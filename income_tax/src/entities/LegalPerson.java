package entities;

public class LegalPerson extends Person{
	
	private Double quantityEmployees;
	private final double TAX_RATE1 = 0.16;
	private final double TAX_RATE2 = 0.14;
	

	public Double getQuantityEmployees() {
		return quantityEmployees;
	}

	public LegalPerson(String name, Double annualIncome, Double quantityEmployees) {
		super(name, annualIncome);
		this.quantityEmployees = quantityEmployees;
	}
	
	@Override
	public double tax() {
		if(quantityEmployees > 10) {
			return annualIncome * TAX_RATE2;
		}
		else {
			return annualIncome * TAX_RATE1;
		}
	}
	
	
}
