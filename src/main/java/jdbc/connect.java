package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    public static void main(String[] args) {
        Connection con = null;
        String server = "localhost:3306";
        String db="example";
        String user_name = "root";
        String password = "1111";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.print("hhhhhhhhh");

    } catch (ClassNotFoundException e) {
        System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
        e.printStackTrace();
    }

    // 2.연결
    try {
        con = DriverManager.getConnection("jdbc:mysql://" + server + "/"+db + "?serverTimezone=UTC&useSSL=false", user_name, password);
        System.out.println("정상적으로 연결되었습니다.");
    } catch(SQLException e) {
        System.err.println("con 오류:" + e.getMessage());
        e.printStackTrace();
    }

    // 3.해제
    try {
        if(con != null)
            con.close();
    } catch (SQLException e) {
        return ;
    }
}
}
