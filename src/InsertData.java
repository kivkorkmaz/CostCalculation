
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertData {
	public static void main (String [] args) {
		
		Connection conn = null;
		Statement statmnt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Veritabanına bağlanılıyor.");
			conn = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/cost_calculation","root","");
			System.out.println("Veritabanına bağlantı sağlandı.");
			
			statmnt = conn.createStatement();
			
			String sql ="INSERT INTO infos " + 
			"VALUES(4,'User Screen',1,1)";
			statmnt.executeUpdate(sql);
			
			
			System.out.println("Ekleme Başarılı");
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(statmnt!=null)
						conn.close();
					 
				}catch(SQLException se) {
					
				}
				try {
					if(conn !=null)
						conn.close();
					
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
	
		}
	}
