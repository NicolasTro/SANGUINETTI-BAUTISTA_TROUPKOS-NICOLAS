package dao;
import java.sql.*;


public class BD {

	public static Connection getConnection() throws Exception {
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection("jdbc:h2:./BDOdontologos",
				"sa", "sa");
	}
}