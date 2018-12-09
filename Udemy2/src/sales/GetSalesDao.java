package sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;



public class GetSalesDao {
	private static final String STMT_SELECT_ALL = "SELECT CUSTOMERID,DLRID,VIN,SALEDATE,MODEL,CURRENCY,SALESPRICE from udemy2.sales";
	private DataSource ds;
	private ResultSet rs;
	private ArrayList<Sales> list;

		
	public List<Sales> getSales(){
		try{
		InitialContext ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
		Connection conn = ds.getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(STMT_SELECT_ALL);
	    rs = pstmt.executeQuery();
	    list = new ArrayList<Sales>();
	    
	    while (rs.next()) {
	        Sales s = new Sales(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7));
	        list.add(s);
	    }
	    
	    conn.close();
	    
		} catch (Exception e){
			e.printStackTrace();
		};
		return list;
	}


}
