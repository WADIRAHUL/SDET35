package json;

import org.junit.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	@Test
	public void createContact() {
		System.out.println("Test1");
		System.out.println("Test2");
		Assert.fail();
		System.out.println("Test3");
	}
	
	@Test
	public void modifyContact() {
		System.out.println("Test4");
		System.out.println("Test5");
		System.out.println("Test6");
	}
}
