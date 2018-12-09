package forecast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;



public class ForecastMonthlyDao {
	private static final String STMT_INSERT_UPDATE = "REPLACE INTO astro.forecast_monthly (year,month,sign,general,finance,health,relationship,family,advice,luckydays) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String STMT_INSERT_UPDATE_JSON = "REPLACE INTO astro.forecast (year,month,sign,forecast) values(?,?,?,?)";
	private static final String STMT_SELECT_FORECAST = "SELECT general,finance,health,relationship,family,advice,luckydays from astro.forecast_monthly where year= ? and month = ? and sign = ?";
	private static final String STMT_SELECT_FORECAST_JSON = "SELECT forecast from astro.forecast where year= ? and month = ? and sign = ?";
	private int rowsupdated = 0;
	private ResultSet rs;
	private Forecast forecast = null;
	private ForecastJSON forecastjson = null;
	

	public ForecastMonthlyDao() {
		// TODO Auto-generated constructor stub
	}
	
	public int setForecastMonthly(Forecast forecast){
	try{
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AstroDB");
		Connection conn = ds.getConnection();
	    PreparedStatement pstmt = conn.prepareStatement(STMT_INSERT_UPDATE);
	    pstmt.setInt(1,forecast.getYear());
	    pstmt.setInt(2,forecast.getMonth());
	    pstmt.setString(3,forecast.getSign());
	    pstmt.setString(4, forecast.getGeneral());
	    pstmt.setString(5,forecast.getFinance());
	    pstmt.setString(6, forecast.getHealth());
	    pstmt.setString(7,forecast.getRelationship());
	    pstmt.setString(8, forecast.getFamily());
	    pstmt.setString(9,forecast.getAdvice());
	    pstmt.setString(10, forecast.getLuckydays());
	    rowsupdated = pstmt.executeUpdate();
	    conn.close();        
		} catch (Exception e){
			System.out.println("Error in: " + e.getClass() + "  triggered from " + this.getClass());
		};
		return rowsupdated;
	}
	
	public Forecast getForecastMonthly(int year,int month,String sign){
		try{
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AstroDB");
			Connection conn = ds.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(STMT_SELECT_FORECAST);
		    pstmt.setInt(1,year);
		    pstmt.setInt(2,month);
		    pstmt.setString(3,sign);
		    rs = pstmt.executeQuery();
		    while(rs.next()){
		    	forecast = new Forecast(year,month,sign,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		    }
	        } catch(Exception e){
	        	e.printStackTrace();
	        }

	  return forecast;
	
}
	public int setForecastMonthly(ForecastJSON forecast){
		try{
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AstroDB");
			Connection conn = ds.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(STMT_INSERT_UPDATE_JSON);
		    pstmt.setInt(1,forecast.getYear());
		    pstmt.setInt(2,forecast.getMonth());
		    pstmt.setString(3,forecast.getSign());
		    pstmt.setString(4, forecast.getForecast());
		    rowsupdated = pstmt.executeUpdate();
		    conn.close();        
			} catch (Exception e){
				System.out.println("Error in: " + e.getClass() + "  triggered from " + this.getClass());
			};
			return rowsupdated;
		}
		
	public ForecastJSON getForecastMonthlyJSON(int year,int month,String sign){
		try{
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AstroDB");
			Connection conn = ds.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(STMT_SELECT_FORECAST_JSON);
		    pstmt.setInt(1,year);
		    pstmt.setInt(2,month);
		    pstmt.setString(3,sign);
		    rs = pstmt.executeQuery();
		    while(rs.next()){
		    	forecastjson = new ForecastJSON(year,month,sign,rs.getString(1));
		    }
	        } catch(Exception e){
	        	e.printStackTrace();
	        }

	  return forecastjson;
	
}

	
}
