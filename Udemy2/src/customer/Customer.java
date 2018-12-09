package customer;

public class Customer {
	
	private String customerid;
	private String email;
	private String firstname;
	private String lastname;
	private String street;
	private String city;
	private String state;
	private String phone;
	private String gender;
	
	public Customer(String customerid, String firstname,
			String lastname, String street, String city, String state,
			String phone, String email, String gender) {
		super();
		this.customerid = customerid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.gender = gender;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	
	
	
	
	
}
