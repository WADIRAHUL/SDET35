package json;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	@Test
	public void createContact() {
		SoftAssert soft = new SoftAssert();
		System.out.println("Test1");
		System.out.println("Test2");
		soft.fail();
		System.out.println("Test3");
		soft.assertAll();
	}
	
	@Test
	public void modifyContact() {
		System.out.println("Test4");
		System.out.println("Test5");
		System.out.println("Test6");
	}
}
