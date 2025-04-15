package testNg;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
@Test
public class SampleTest extends BaseClass {

	//@Test(priority=1)
	public void createContact() {
		System.out.println("Contact Created");
	}

//	@Test(priority=2)
	public void modifyContact() {
		System.out.println("Contact Modified");
	}

	//@Test(priority=-1)
	public void deleteContact() {
		System.out.println("Contact Deleted");
	}
}