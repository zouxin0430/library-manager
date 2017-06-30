/**
 * 
 */
package zouxin.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ZouXin
 * 2017-3-25
 */
public class JdbcUtil {
   static{
	   try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public static Connection getConnection() throws SQLException{
	   String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		return DriverManager.getConnection(url, "hr", "hr");
   }
}
