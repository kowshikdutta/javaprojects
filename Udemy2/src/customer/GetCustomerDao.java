package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GetCustomerDao {
	private static final String STMT_SELECT_ALL = "SELECT CUSTOMERID,FIRSTNAME,LASTNAME,STREET,CITY,STATE,PHONE,EMAIL,GENDER FROM udemy2.customer";
	private DataSource ds;
	private ResultSet rs;
	private ArrayList<Customer> list;
	public List<Customer> getCustomer() throws Exception {
	
	try{
		InitialContext ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(STMT_SELECT_ALL);
	    rs = pstmt.executeQuery();
        list = new ArrayList<Customer>();
	    
	    while (rs.next()) {
	        Customer c = new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
	        list.add(c);
	        
	    }	    
	    conn.close();	
	} catch (Exception e){
		System.out.println("Error in: " + e.getClass() + "  triggered from " + this.getClass());
		throw(e);
				
	};
	
	return list;
	    
	}   
	    

}
