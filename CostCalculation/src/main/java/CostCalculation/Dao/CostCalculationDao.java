package CostCalculation.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.sql.ResultSet;
public class CostCalculationDao {
	
public static void main (String [] args) throws Exception {	
	
	
		Connection conn = null;
		Statement statmnt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Veritabanına bağlanılıyor.");
			conn = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/cost_calculation","root","");
			System.out.println("Veritabanına bağlantı sağlandı.");
			
			statmnt = conn.createStatement();
			
			String sql = "SELECT * FROM infos";
					ResultSet rs = statmnt.executeQuery(sql);
					
				while(rs.next()) {
					int costno = rs.getInt("costno");
					String name = rs.getString("name");
					int cost = rs.getInt("cost");
				       System.out.print("ID: " + costno);
			            System.out.print(", Name: " + name);
			            System.out.print(", CostNo: " + cost);
			            System.out.println();
			         }
			
				rs.close();
				statmnt.close();
		         conn.close();
		      } catch(SQLException se) {
		         se.printStackTrace();
		      } catch(Exception e) {
		         e.printStackTrace();
		      } finally {
		         try {
		            if(statmnt!=null)
		            	statmnt.close();
		         } catch(SQLException se2) {
		         }
		         try {
		            if(conn!=null)
		               conn.close();
		         } catch(SQLException se) {
		            se.printStackTrace();
		         }
		      }
		   }
		}