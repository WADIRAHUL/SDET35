package json_OtherProg;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Selenium_Grid {
	RemoteWebDriver driver;
	@Parameters("browser")
	@Test
	public void sampleRun(String browser) throws Exception {
		
		URL url = new URL("http://192.168.43.69:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if (browser.equals("chrome")) {
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}else if (browser.equals("firefox")) {
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		driver = new RemoteWebDriver(url, cap);
				
		driver.get("https://www.naukri.com/");
	}
}
