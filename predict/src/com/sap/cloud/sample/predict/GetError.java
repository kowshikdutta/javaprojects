package com.sap.cloud.sample.predict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetError
 */
public class GetError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String line;
		String contextpath = getServletContext().getRealPath("/");
		char fileSeparator = contextpath.charAt((contextpath.length()) - 1);
		String path = contextpath +"sampledata" + fileSeparator + "ErrorFile.txt";
		File fileSample = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(fileSample));
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment;filename=\"ErrorFile.txt\"");
		response.setContentLength((int) fileSample.length());
		PrintWriter pw = response.getWriter();
        
		try {
		    while ((line = br.readLine())!= null) {
		       pw.print(line + "\r\n");
		    }
	        pw.flush(); 
		} catch (Exception excp) {
		    excp.printStackTrace();
		} finally {
		    br.close();
		    pw.close();
		}
		
	}
	

}
