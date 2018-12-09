package sales;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class GetSales
 */
@WebServlet(description = "Get Sales Data", urlPatterns = { "/GetSales" })
public class GetSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject jsonsales      = new JSONObject();
        JSONArray  jsonsaleslist  = new JSONArray();
        JSONObject tempsales;
        
        
		GetSalesDao saleslist = new GetSalesDao();
		Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		List<Sales> sales = saleslist.getSales();
		
		try {
		for(Sales s:sales){
			tempsales = new JSONObject();
				tempsales.put("CUSTOMERID",s.getCUSTOMERID());
				tempsales.put("DLRID",s.getDLRID());
				tempsales.put("VIN",s.getVIN());
				tempsales.put("SALESDATE", formatter.format(s.getSALEDATE()));
				tempsales.put("MODEL",s.getMODEL());
				tempsales.put("SALESPRICE",s.getSALEPRICE());
				tempsales.put("CURRENCY",s.getCURRENCY());
			jsonsaleslist.put(tempsales);
		}
		jsonsales.put("SalesList", jsonsaleslist);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		response.setContentType("application/json");
		
        try{
		  response.getWriter().write(jsonsales.toString());
		  response.flushBuffer();
        }catch (Exception e){
        	e.printStackTrace();
        }
        
        
	}



}
