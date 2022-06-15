package json;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test(priority = 5)
	public void show() {
		System.out.println("hello");
	}
	@Test(priority = 1)
	public void contact() {
		System.out.println("contct");
	}
	
	@Test(priority = -5)
	public void modify() {
		System.out.println("modify");
	}

}
