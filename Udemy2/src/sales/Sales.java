package sales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sales {
	private String CUSTOMERID;
	private String DLRID;
	private String VIN;
	private Date SALEDATE;
	private String MODEL;
	private String CURRENCY;
	private String SALEPRICE;
	
	public Sales(String cUSTOMERID, String dLRID, String vIN, String sALEDATE,
			String mODEL,String cURRENCY, String sALEPRICE) {
		super();
		CUSTOMERID = cUSTOMERID;
		DLRID = dLRID;
		VIN = vIN;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 
		try {
	 
			SALEDATE = (Date) formatter.parse(sALEDATE);
				 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MODEL    = mODEL;
		CURRENCY = cURRENCY;
		SALEPRICE = sALEPRICE;
	}
	
	public String getMODEL() {
		return MODEL;
	}
	
	public Date getSALEDATE() {
		return SALEDATE;
	}
	public void setSALEDATE(Date sALEDATE) {
		SALEDATE = sALEDATE;
	}
	public String getCURRENCY() {
		return CURRENCY;
	}
	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}
	public String getSALEPRICE() {
		return SALEPRICE;
	}
	public void setSALEPRICE(String sALEPRICE) {
		SALEPRICE = sALEPRICE;
	}
	
	public String getCUSTOMERID() {
		return CUSTOMERID;
	}
	public void setCUSTOMER(String cUSTOMERID) {
		CUSTOMERID = cUSTOMERID;
	}
	public String getDLRID() {
		return DLRID;
	}
	public void setDLRID(String dLRID) {
		DLRID = dLRID;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	
	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

}
