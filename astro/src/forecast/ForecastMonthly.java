package forecast;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ForecastMonthly
 */
@WebServlet("/forecastmonthly")
public class ForecastMonthly extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int year;
	private int month;
	private String sign;
	private String general;
	private String health;
	private String finance;
	private String relationship;
	private String family;
	private String advice;
	private String luckydays;
	private Forecast forecast;
	private int result;
	private String header;
	private ForecastJSON forecastjson;
	private String monthlyforecast;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForecastMonthly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		year  =  Integer.parseInt(request.getParameter("Year"));
		month =  Integer.parseInt(request.getParameter("Month"));
		sign  =  request.getParameter("Sign");
		header = "<h3>" + sign + "   December " +  year + "</h3>";
		forecast = new ForecastMonthlyDao().getForecastMonthly(year, month, sign);
		if(forecast!=null){
		general = "<h2>General</h2><p>" + forecast.getGeneral() + "</p><br>";
		finance = "<h2>Finance</h2><p>" + forecast.getFinance()+ "</p><br>"; 
		health  ="<h2>Health</h2><p>" + forecast.getHealth() + "</p><br>";
		relationship = "<h2>Relationship</h2><p>" + forecast.getRelationship()+ "</p><br>";
		family = "<h2>Family & Friends</h2><p>" + forecast.getFamily() + "</p><br>";
		advice = "<h2>Advice</h2><p>" + forecast.getAdvice() + "</p><br>";
		luckydays = "<h2>Lucky Days</h2><p>" + forecast.getLuckydays() + "</p><br>";
		response.setContentType("text/html");
		response.getWriter().print(header + general + finance + health + relationship + family + advice + luckydays);
		}else{
		response.setContentType("text/html");
		response.getWriter().print(header + "<h2>No Data Found</h2>");
		}
		response.flushBuffer();
	} */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		year = Integer.parseInt(request.getParameter("Year"));
		month = Integer.parseInt(request.getParameter("Month"));
		sign = request.getParameter("Sign");
		general = request.getParameter("General");
		health  = request.getParameter("Health");
		finance = request.getParameter("Finance");
		relationship = request.getParameter("Relationship");
		family = request.getParameter("Family");
		advice = request.getParameter("Advice");
		luckydays = request.getParameter("Luckydays");
		
		forecast = new Forecast(year,month,sign,general,finance,health,relationship,family,advice,luckydays);
		result = new ForecastMonthlyDao().setForecastMonthly(forecast);
		
		response.getWriter().print(result);
		response.flushBuffer();
	} */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		year = Integer.parseInt(request.getParameter("Year"));
		month = Integer.parseInt(request.getParameter("Month"));
		sign = request.getParameter("Sign");
		monthlyforecast = request.getParameter("forecast");
		
		forecastjson = new ForecastJSON(year,month,sign,monthlyforecast);
		result = new ForecastMonthlyDao().setForecastMonthly(forecastjson);
		
		response.getWriter().print(result);
		response.flushBuffer();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		year  =  Integer.parseInt(request.getParameter("Year"));
		month =  Integer.parseInt(request.getParameter("Month"));
		sign  =  request.getParameter("Sign");
		header = "<h3>" + sign + "   December " +  year + "</h3>";
		forecastjson = new ForecastMonthlyDao().getForecastMonthlyJSON(year, month, sign);
		if(forecastjson!=null){
		response.setContentType("text/json");
		response.getWriter().print(forecastjson.getForecast());
		}else{
		response.setContentType("text/html");
		response.getWriter().print("{\"Result\":\"No Data Found\"}");
		}
		response.flushBuffer();
	}

}
