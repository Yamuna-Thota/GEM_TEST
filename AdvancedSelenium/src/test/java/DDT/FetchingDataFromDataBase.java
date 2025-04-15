package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDataFromDataBase {

	public static void main(String[] args) throws Throwable {
//Loading the Database
		Driver driverRef = new Driver();

		//DriverManager.registerDriver(driverRef);

		// connecting to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "ythota", "Sasi@123");
//writing/creating sql statement
		Statement state = conn.createStatement();

		String query = ("Select * from Employee");
//executing  the query
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
			
			System.out.println(result.getString("Name")+" "+ result.getInt("phNO")+" "+result.getString("Address"));
			//System.out.println(result.getString(1)+" "+ result.getInt(2)+" "+result.getString(3));
		}
		conn.close();
	}

}
