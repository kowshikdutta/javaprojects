package dealer;


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
 * Servlet implementation class GetDealer
 */
@WebServlet("/GetDealer")
public class GetDealer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDealer() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject jsondealer = new JSONObject();
        JSONArray  jsondealerlist  = new JSONArray();
        JSONObject tempdealer;
        
        
		GetDealerDao dealerlist = new GetDealerDao();
		
		List<Dealer> dealer = dealerlist.getDealer();
		try {
		for(Dealer d:dealer){
			tempdealer = new JSONObject();
			
			    tempdealer.put("DLRID", d.getDLRID());
			    tempdealer.put("DLRNAME", d.getDLRNAME());
			    tempdealer.put("DLRADDRESS", d.getDLRADDRESS());
			    tempdealer.put("DLRCONTACT", d.getDLRCONTACT());
			    tempdealer.put("DLRPHONE", d.getDLRPHONE());
			    tempdealer.put("DLRMAIL", d.getDLRMAIL());
			    
			jsondealerlist.put(tempdealer);
		}
		jsondealer.put("DealerList", jsondealerlist);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
       response.setContentType("application/json");
		
        try{
		  response.getWriter().write(jsondealer.toString());
		  response.flushBuffer();
        }catch (Exception e){
        	e.printStackTrace();
        }

	}





}
