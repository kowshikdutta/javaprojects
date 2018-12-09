package model;

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
 * Servlet implementation class GetModel
 */
@WebServlet(description = "GetModel", urlPatterns = { "/GetModel" })
public class GetModel extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        JSONObject jsonmodel = new JSONObject();
        JSONArray  jsonmodellist  = new JSONArray();
        JSONObject tempmodel;       
        
		GetModelDao modellist = new GetModelDao();
		
		List<Model> model = modellist.getModel();
		
		try {
		for(Model m:model){
			tempmodel = new JSONObject();
				tempmodel.put("Model", m.getModel());
				tempmodel.put("Brand", m.getBrand());
			jsonmodellist.put(tempmodel);
		}
		jsonmodel.put("ModelList", jsonmodellist);
		} catch (JSONException e) {
			e.printStackTrace();
		}
      
		response.setContentType("application/json");
		
        try{
		  response.getWriter().write(jsonmodel.toString());
		  response.flushBuffer();
        }catch (Exception e){
        	e.printStackTrace();
        }
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
