package customer;

import java.io.IOException;
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
 * Servlet implementation class GetCustomer
 */
@WebServlet(description = "Get Customer Details", urlPatterns = { "/GetCustomer" })
public class GetCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JSONObject jsoncustomer = new JSONObject();
        JSONArray  jsoncustomerlist  = new JSONArray();
        JSONObject tempcustomer;
        List<Customer> customerlist = null;
        
        try {
			customerlist = (new GetCustomerDao()).getCustomer();
		
		for(Customer c:customerlist){
			tempcustomer = new JSONObject();
			
				tempcustomer.put("CustomerId", c.getCustomerid());
				tempcustomer.put("Firstname", c.getFirstname());
				tempcustomer.put("Lastname", c.getLastname());
				tempcustomer.put("Street", c.getStreet());
				tempcustomer.put("City", c.getCity());
				tempcustomer.put("State", c.getState());
				tempcustomer.put("Phone", c.getPhone());
				tempcustomer.put("Email", c.getEmail());
				tempcustomer.put("Gender", c.getGender());
			
			jsoncustomerlist.put(tempcustomer);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        try {
			jsoncustomer.put("CustomerList", jsoncustomerlist);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        response.setContentType("application/json");
		
        try{
		  response.getWriter().write(jsoncustomer.toString());
		  response.flushBuffer();
        }catch (Exception e){
        	e.printStackTrace();
        }
        
	}

}
