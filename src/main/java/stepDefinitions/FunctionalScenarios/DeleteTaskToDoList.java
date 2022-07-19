package stepDefinitions.FunctionalScenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import utils.ReadPropertyFile;
import utils.SharedResource;

public class DeleteTaskToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	WebElement TextBoxClick;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By AllTab = By.cssSelector(".selected");
	private By ActiveTab = By.cssSelector(".filters > li:nth-of-type(2) > a");
	private By deletebutton=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/button[@class='destroy']");
	
	public DeleteTaskToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Delete-Launch the To Do List URL$")
	public void launch_the_ToDoList_URL() throws IOException, InterruptedException {
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Delete-User enters a Task \\\"([^\\\"]*)\\\" and click enter$")
	public void add_User_enters_a_Task_and_click_enter(String Task1) throws IOException, InterruptedException {
		
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task1);
		WebElement textbox = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox.sendKeys(Keys.ENTER);
		SharedResource wait = new SharedResource();
		wait.waitElement();
		

	}
	@And("^Delete-Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_added_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Delete the task by click on close button at the end of the task$")
	public void Delete_the_task_by_click_on_close_button_at_the_end_of_the_task() throws InterruptedException {
		SharedResource wait = new SharedResource();
		WebElement Deletebutton = driver.findElement(deletebutton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Deletebutton);
        
       // js.executeScript("arguments[0].onmouseover()", Deletebutton);
        wait.waitElement();
	}

	@Then("^Close the DeleteTask browser$")
	public void close_the_browser() {
		driver.quit();
	}
}
