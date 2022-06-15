package json;

import org.testng.annotations.Test;

public class Sample {
	
	@Test(priority = 3)
	public void createContact() {
		System.out.println("Contact Created");
	}
	@Test(priority = 1)
	public void modifyContact() {
		System.out.println("Contact Modified");
	}
	@Test(priority = 2)
	public void deleteContact() {
		System.out.println("Contact Deleted");
	}
}
