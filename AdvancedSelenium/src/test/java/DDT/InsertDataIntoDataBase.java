package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {
		Driver driverRef = new Driver();
		//DriverManager.registerDriver(driverRef);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "ythota", "Sasi@123");

//INsertng data into DB
		Statement state = conn.createStatement();

		String query = "insert into Employee values('Yamuna',76,'Hyd')";
		String query1 = "insert into Employee values('Eswar',76,'Karnataka')";
		String query2 = "insert into Employee values('venkat',89,'Navara')";

		int result = state.executeUpdate(query);
		int result1 = state.executeUpdate(query1);
		int result2 = state.executeUpdate(query2);

		if (result == 1 && result1 == 1 && result2 == 1) {
			System.out.println("Data Inserted");
		} else {
			System.out.println("Data Not Inserted");
		}
		conn.close();

	}

}
