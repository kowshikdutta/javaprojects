package com.sap.cloud.sample.predict;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Scanner;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class PredictServlet
 */
@MultipartConfig

public class PredictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(PredictServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder input = new StringBuilder();
		String temp;
		ProcessData predict = null;
		try{
			String deliveryDate = request.getParameter("datepicker");
			String deliverynumber  = request.getParameter("deliverynumber");
			Part inputfilePart = request.getPart("historyfile");
			if(inputfilePart != null){ 
				Scanner scanner = new Scanner(inputfilePart.getInputStream());
				while(scanner.hasNext()){
					temp = scanner.nextLine();
					input.append(temp + "|");
				}
				System.out.println("Delivery date is: " + deliveryDate);
				predict = new ProcessData(deliveryDate,deliverynumber,input);
			}else{System.out.println("All is null");}
		}catch (Exception e){
			logger.error(e.getMessage());
		}

		if(predict != null){response.getWriter().print(predict.getOutput().toString());
		}else{
			response.getWriter().print("Error on server side");
			logger.error("Error on server side");
		}
		logger.trace("Completed prediction successfully");
	}
}
