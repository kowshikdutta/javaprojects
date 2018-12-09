package dealer;


public class Dealer {
	

	private String DLRID;
	private String DLRNAME;
	private String DLRADDRESS;
	private String DLRCONTACT;
	private String DLRPHONE;
	private String DLRMAIL;


	public  Dealer(String dlrid,String dlrname,String dlraddress,String dlrcontact,String dlrphone,String dlrmail){
		this.DLRID = dlrid;
		this.DLRNAME = dlrname;
		this.DLRADDRESS = dlraddress;
		this.DLRCONTACT = dlrcontact;
		this.DLRPHONE = dlrphone;
		this.DLRMAIL  = dlrmail;
		
	}
	public String getDLRID() {
		return DLRID;
	}


	public void setDLRID(String dLRID) {
		DLRID = dLRID;
	}


	public String getDLRNAME() {
		return DLRNAME;
	}


	public void setDLRNAME(String dLRNAME) {
		DLRNAME = dLRNAME;
	}


	public String getDLRADDRESS() {
		return DLRADDRESS;
	}


	public void setDLRADDRESS(String dLRADDRESS) {
		DLRADDRESS = dLRADDRESS;
	}


	public String getDLRCONTACT() {
		return DLRCONTACT;
	}


	public void setDLRCONTACT(String dLRCONTACT) {
		DLRCONTACT = dLRCONTACT;
	}


	public String getDLRPHONE() {
		return DLRPHONE;
	}


	public void setDLRPHONE(String dLRPHONE) {
		DLRPHONE = dLRPHONE;
	}


	public String getDLRMAIL() {
		return DLRMAIL;
	}


	public void setDLRMAIL(String dLRMAIL) {
		DLRMAIL = dLRMAIL;
	}




}
