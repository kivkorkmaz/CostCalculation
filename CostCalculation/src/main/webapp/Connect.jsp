<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Efor Hesaplama</title>
</head>
<body>
    <center>
        <select>
            <option>Seçiniz</option>
            <%  
            try {
                String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
                String DB_URL = "jdbc:mysql://localhost:3306/cost_calculation";
                String USER = "root";
                String PASS = "";

                Class.forName(JDBC_DRIVER);
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();

                String sql = "SELECT * FROM infos";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
            %>
            <option><%= rs.getString(sql) %></option>
            <%
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </select>
    </center>
</body>
</html>
