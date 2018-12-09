package forecast;

public class Forecast {
	private int year, month;
	private String sign,general,finance,health,relationship,family,advice,luckydays;

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

	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	public String getFinance() {
		return finance;
	}

	public void setFinance(String finance) {
		this.finance = finance;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getLuckydays() {
		return luckydays;
	}

	public void setLuckydays(String luckydays) {
		this.luckydays = luckydays;
	}

	public Forecast() {
		// TODO Auto-generated constructor stub
	}

	public Forecast(int year, int month, String sign, String general,
			String finance, String health, String relationship, String family,
			String advice, String luckydays) {
		super();
		this.year = year;
		this.month = month;
		this.sign = sign;
		this.general = general;
		this.finance = finance;
		this.health = health;
		this.relationship = relationship;
		this.family = family;
		this.advice = advice;
		this.luckydays = luckydays;
	}

}
