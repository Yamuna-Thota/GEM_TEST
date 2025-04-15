package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	//You're using DataProvider to run the same test method multiple times with different data.
	@Test(dataProvider ="getData")
	public void bookTickets(String src,String dest,int NumOfPpl) {
		System.out.println("Book Tickets from "+ src+" to " + dest+"---->"+NumOfPpl);
	}
@DataProvider
	public Object[][] getData() {
		
		Object[][] objArray = new Object[3][3];
		objArray[0][0] ="Bangalore";
		objArray[0][1] ="Goa";
		objArray[0][2] =10;
		
		objArray[1][0] ="Bangalore";
		objArray[1][1] ="Mysore";
		objArray[1][2] =10;
		
		objArray[2][0] ="Bangalore";
		objArray[2][1] ="Hyd";
		objArray[2][2] =10;
		
		return objArray;
	}
}
