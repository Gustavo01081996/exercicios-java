package entities;

public abstract class Person {
	
	protected String name;
	protected Double annualIncome;

	public String getName() {
		return name;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}


	public Person(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}
	
	public abstract double tax();
	
	@Override
	public String toString() {
		return name + ": $" + String.format("%.2f", tax());
	}
}
