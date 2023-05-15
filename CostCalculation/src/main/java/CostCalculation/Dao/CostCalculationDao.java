package CostCalculation.Dao;

import java.sql.*
import java.util.ArrayList

public class CostCalculationDao {

    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/cost_calculation";
    private final String USER = "root";
    private final String PASS = "";

    public static void main(String[] args) throws Exception {

        CostCalculationDao dao = new CostCalculationDao();
        ArrayList<Info> infos = dao.getAllInfos();

        for (Info info : infos) {
            System.out.println(info.getCostno() + " " + info.getName() + " " + info.getCost());
        }
    }

    private ArrayList<Info> getAllInfos() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Info> infos = new ArrayList<>();

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Veritabanına bağlanılıyor.");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Veritabanına bağlantı sağlandı.");

            stmt = conn.createStatement();

            String sql = "SELECT * FROM infos";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int costno = rs.getInt("costno");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                infos.add(new Info(costno, name, cost));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se2) {
            }
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return infos;
    }
}
