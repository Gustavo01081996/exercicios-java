package entities;

public class NaturalPerson extends Person{
	
	private Double healthcareExpenses;
	private final Double INCOME_LIMIT = 20000.0;
	private final Double HEALTH_EXPENSES_LIMIT = 0.5;
	private final Double TAX_RATE1 = 0.15;
	private final Double TAX_RATE2 = 0.25;
	public Double getHealthcareExpenses() {
		return healthcareExpenses;
	}

	public NaturalPerson(String name, Double annualIncome, Double healthcareExpenses) {
		super(name, annualIncome);
		this.healthcareExpenses = healthcareExpenses;
	}
	
	@Override
	public double tax() {
		if(this.annualIncome < INCOME_LIMIT && healthcareExpenses == 0.0) {
			return (annualIncome * TAX_RATE1);
		} 
		else if(this.annualIncome  < INCOME_LIMIT && healthcareExpenses > 0) {
			return (annualIncome * TAX_RATE1) - (healthcareExpenses * HEALTH_EXPENSES_LIMIT);
		}
		else if(this.annualIncome > INCOME_LIMIT && healthcareExpenses == 0.0) {
			return (annualIncome * TAX_RATE2);
		}
		else {
			return (annualIncome * TAX_RATE2) - (healthcareExpenses * HEALTH_EXPENSES_LIMIT);
		}
	}
	

	

}
