package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;



public class GetModelDao 
{
	
private static final String STMT_SELECT_ALL = "select MODEL, BRAND from udemy2.model";
private DataSource ds;
private ResultSet rs;
private ArrayList<Model> list;

	
public List<Model> getModel(){
	try{
	InitialContext ctx = new InitialContext();
	ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
	Connection conn = ds.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(STMT_SELECT_ALL);
    rs = pstmt.executeQuery();
    

    
    list = new ArrayList<Model>();
    
    while (rs.next()) {
        Model m = new Model(rs.getString(1),rs.getString(2));
        list.add(m);
    }
    
    conn.close();
    
	} catch (Exception e){
		e.printStackTrace();
	};

	return list;
}
}
