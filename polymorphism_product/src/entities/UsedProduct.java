package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date manufactureDate;

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + " (used) $" + String.format("%.2f", this.price) + " Manufacture date: "
				+ sdf.format(manufactureDate));
		return sb.toString();
	}

}
