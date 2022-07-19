package stepDefinitions.FunctionalScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import junit.framework.Assert;
import utils.ReadPropertyFile;
import utils.SharedResource;

public class LoginTaskToDoList{

	 WebDriver driver;
	 ReadPropertyFile readPropertyFile;
	 public LoginTaskToDoList(SharedResource sharedResource) throws InterruptedException {
			this.driver = sharedResource.init();
		}
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page() throws IOException, InterruptedException{
		 
	 //System.setProperty("webdriver.chrome.driver","src/main/java/chromedriver.exe");
	 //driver = new ChromeDriver();
	 readPropertyFile = new ReadPropertyFile();
	 driver.get(readPropertyFile.getTodoListURL());
	 SharedResource wait = new SharedResource();
	 wait.waitElement();
	 }
	
	
	 @When("^title of login page is Vue.js • TodoMVC$")
	 public void title_of_login_page_Vue_js_TodoMVC() throws InterruptedException{
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Vue.js • TodoMVC", title);
	 SharedResource wait = new SharedResource();
     wait.waitElement();
	 }

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	

}
