package salesreports;

public class Contribution {
	private String Brand;
	private String Model;
	private Double SalesPrice;
	private String Currency;
	
	
	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getMODEL() {
		return Model;
	}

	public void setMODEL(String model) {
		Model = model;
	}

	public Double getSalesPrice() {
		return SalesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		SalesPrice = salesPrice;
	}


	public Contribution(String brand, String model,String currency, Double salesprice) {
		super();
		Model = model;
		SalesPrice = salesprice;
		setBrand(brand);
		Currency = currency;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}
	
	
}
