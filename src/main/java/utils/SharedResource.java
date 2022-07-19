package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;



public class SharedResource {

	
	 WebDriver driver;
	 public WebDriver init() {
			if (driver == null) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
			}
			return driver;
		}
	 public WebDriver waitElement() throws InterruptedException {
		 Thread.sleep(3000);
	return driver;
}

}
