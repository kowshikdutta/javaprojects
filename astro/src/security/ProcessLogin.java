package security;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessLogin
 */
@WebServlet(description = "Process User Login and Authorize", urlPatterns = { "/processlogin" })
public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String userid,password;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		userid   = request.getParameter("userid");
		password = request.getParameter("password");
		
		System.out.println("UserID" + userid + "Password" + password);
		
		if(userid.equals("guest1@astro.com") && password.equals("abcd1234")){
			response.getWriter().print("Customer");
		} else if (userid.equals("admin1@astro.com") && password.equals("efgh1234"))
		{
			response.getWriter().print("Astrologer");
		} else {
		response.getWriter().print("Error");
		}
		
		response.flushBuffer();
	}

}
