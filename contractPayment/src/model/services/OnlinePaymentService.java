package model.services;

public interface OnlinePaymentService {
	
	public double paymentFee(double ammout);
	public double interest(double amount, int months);

}
