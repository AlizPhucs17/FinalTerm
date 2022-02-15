package CuoiKi.Icons.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class databaseHelper {
	static Connection conn;
	public static Connection connect() {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-JDLBPEJL\\SQLEXPRESS:1433;databaseName=QuanLy_SV;user=sa;password=Huda0107 ");
		System.out.println("Connected");
	} catch(Exception e) {
		e.printStackTrace();
	}
	return conn;
}
}
