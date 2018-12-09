package com.sap.cloud.sample.predict;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.json.JSONObject;

public class ProcessData {

	private  StringBuilder  response, error; 
	private  String filedata, deliverydate,onesigma,twosigma,threesigma;
	private  int validCount = 0, errorCount = 0, recordCount = 0,deliverynumber;
	private  double mean = 0, stddiv = 0;
	
	public ProcessData(String deldate,String delNumber,StringBuilder in){

		deliverydate   = deldate;
		deliverynumber = Integer.parseInt(delNumber);
		filedata = in.toString();
		
		response = new StringBuilder();
		error = new StringBuilder();
		

		
        computeStat();
        createPrediction();
		createResponse();
		
// Prepare the final output	in JSON
		
		
		
	}
	
	private void computeStat() {
		String row;
		String[] parts;
		long diff,diffdays;
		// TODO Auto-generated method stub
//        System.out.println("Number of rows: "+recordCount);
		StringTokenizer st = new StringTokenizer(filedata,"|");

		recordCount = st.countTokens();
//        System.out.println("Number of rows: "+recordCount);
		int[] diffdate = new int[recordCount];
//        System.out.println("Number of rows: "+1);
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		formatDate.setLenient(false);	
//		System.out.println("Number of rows: "+2);
		Date d1 = new Date();
		Date d2 = new Date();
//        System.out.println("Number of rows: "+recordCount);

		while(st.hasMoreElements()){
			row = (String) st.nextElement();
			parts = row.split(",");
			
			try{
//				System.out.println("Part 2: "+ parts[2]);
				d1 = formatDate.parse(parts[1]);
				d2 = formatDate.parse(parts[2]);
				diff = d1.getTime() - d2.getTime();
				diffdays = diff/(24*60*60*1000);
				mean = mean + diffdays;
				diffdate[validCount] = (int) diffdays;
				validCount++;		
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				error.append(row + "|");
				errorCount++;

			} catch (NullPointerException e){
				error.append(row + "|");
				errorCount++;
			}
		}

		// Compute mean and standard deviation			
		mean = Math.round(mean / (validCount));
		for(int i = 0; i<validCount; i++){
			stddiv = stddiv + (diffdate[i] - mean)*(diffdate[i] - mean);
		}

		stddiv = Math.round(Math.sqrt(stddiv/(validCount -1)));
		
	}

	
	
	
	private void createPrediction() {
		// TODO Auto-generated method stub
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date delDate;
		try {
			delDate = formatDate.parse(deliverydate);
			Calendar c = Calendar.getInstance();
			c.setTime(delDate);
			c.add(Calendar.DAY_OF_MONTH,(int) mean);
			Date meanDate = c.getTime();
			onesigma = getSigma(delDate,meanDate,1);
			twosigma = getSigma(delDate,meanDate,2);
			threesigma = getSigma(delDate,meanDate,3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
private  String getSigma(Date deldt, Date meandt, int sigma){
	    	String producttext = null;
	    	Calendar c = Calendar.getInstance();
			c.setTime(meandt);
			c.add(Calendar.DAY_OF_MONTH,(int) stddiv * sigma);
			Date oneSigmaEnd = c.getTime();
			c.setTime(meandt);
			c.add(Calendar.DAY_OF_MONTH,-(int) stddiv * sigma);
			Date oneSigmaStart = c.getTime();
			SimpleDateFormat dateFormat1= new SimpleDateFormat("dd-MMM-yyyy");
			switch (sigma){
			case 1: producttext = "Only " + Math.round(deliverynumber * 0.333);break;
			case 2: producttext = "Only " + Math.round(deliverynumber * 0.667);break;
			case 3: producttext = "All " + deliverynumber;break;
			default: break;		
			}
			return producttext +" products will reach between :" + dateFormat1.format(oneSigmaStart) + " and " + dateFormat1.format(oneSigmaEnd) ;
	    }

private  void createResponse(){
	String jsonRow;
	
	
	
	jsonRow = "{\"TotalRecords\":" + recordCount + ",";
	response.append(jsonRow);
	jsonRow = "\"ValidCount\":" + validCount + ",";
	response.append(jsonRow);
	jsonRow = "\"ErrorCount\":" + errorCount + ",";
	response.append(jsonRow);
	jsonRow = "\"Mean\":" + mean + ",";
	response.append(jsonRow);
	jsonRow = "\"StdDiv\":" + stddiv + ",";
	response.append(jsonRow);
	jsonRow = "\"OneSigma\":" + "\"" +onesigma +"\"" + ",";
	response.append(jsonRow);
	jsonRow = "\"TwoSigma\":" + "\"" +twosigma +"\"" + ",";
	response.append(jsonRow);
	jsonRow = "\"ThreeSigma\":" +"\"" + threesigma +"\"" + ",";
	response.append(jsonRow);
	jsonRow = "\"ErrorRows\":" + "\"" + error.toString() + "\"" + "}";
	response.append(jsonRow);


}

public StringBuilder getOutput(){
	return response;
}

}
