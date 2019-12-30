package WeatherForecast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接
 */

public class Conn {
    public Connection getConn(){

        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/weather?&useSSL=false&serverTimezone=GMT%2B8";
        String user="root";
        String password="Qwj1605260500";
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                //System.out.println("数据库连接成功");
                System.out.print("");
            }
         //   con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

        return con;

    }
}
