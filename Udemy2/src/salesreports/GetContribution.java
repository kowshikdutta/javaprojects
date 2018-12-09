package salesreports;

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
 * Servlet implementation class GetContribution
 */
@WebServlet(description = "Get Sales Contribution", urlPatterns = { "/GetContribution" })
public class GetContribution extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetContribution() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject jsoncontribution      = new JSONObject();
		JSONArray  jsoncontrbutionlist  = new JSONArray();
		JSONObject tempcontribution;

		GetContributionDao contributionlist = new GetContributionDao();
		List<Contribution> contribution = contributionlist.getSales();

		try {
			for(Contribution s:contribution){
				tempcontribution = new JSONObject();
				tempcontribution.put("BRAND",s.getBrand());	
				tempcontribution.put("MODEL",s.getMODEL());
				tempcontribution.put("SALESPRICE",s.getSalesPrice());
				tempcontribution.put("CURRENCY",s.getCurrency());
							
				jsoncontrbutionlist.put(tempcontribution);
			}
			jsoncontribution.put("SALESCONTRIBUTIONLIST", jsoncontrbutionlist);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("application/json");

		try{
			response.getWriter().write(jsoncontribution.toString());
			response.flushBuffer();
		}catch (Exception e){
			e.printStackTrace();
		}


	}

}
