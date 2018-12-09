package forecast;

public class ForecastJSON {
	private int year, month;
	private String sign,forecast;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

   public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public ForecastJSON(int year, int month, String sign, String forecast) {
		super();
		this.year = year;
		this.month = month;
		this.sign = sign;
		this.forecast = forecast;
	}


	
	

	public ForecastJSON() {
		// TODO Auto-generated constructor stub
	}

}
