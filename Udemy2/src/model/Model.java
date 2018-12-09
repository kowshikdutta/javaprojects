package model;

public class Model {

	private String Model;
	private String Brand;
	
	
	public Model(String model, String brand) {
		super();
		Model = model;
		Brand = brand;
	}
	
	public void setBrand(String brnd){
		this.Brand = brnd;
	}
	
	public void setModel(String modl){
		this.Model = modl;
	}
	
	public String getBrand(){
		return this.Brand;
	}
	
	public String getModel(){
		return this.Model;
	}
	
}
