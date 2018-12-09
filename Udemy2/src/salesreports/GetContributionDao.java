package salesreports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GetContributionDao {
	private static final String STMT_SELECT_ALL = "select b.brand, b.model,a.currency, sum(SALESPRICE) from udemy2.sales a, udemy2.model b " +
            "where b.model = a.model group by b.brand, b.model,a.currency";
private DataSource ds;
private ResultSet rs;
private ArrayList<Contribution> list;

public List<Contribution> getSales(){
try{
InitialContext ctx = new InitialContext();
ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
Connection conn = ds.getConnection();
PreparedStatement pstmt = conn.prepareStatement(STMT_SELECT_ALL);    
rs = pstmt.executeQuery();   
list = new ArrayList<Contribution>();    
while (rs.next()) {	
Contribution s = new Contribution(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
list.add(s);
}

conn.close();

} catch (Exception e){
e.printStackTrace();
};
return list;
}

}
