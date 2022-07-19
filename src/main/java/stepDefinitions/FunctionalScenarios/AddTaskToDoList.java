package stepDefinitions.FunctionalScenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import junit.framework.Assert;
import utils.ReadPropertyFile;
import utils.SharedResource;

public class AddTaskToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	WebElement TextBoxClick;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By TaskValue = By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='Requirements']");
	private By AllTab = By.cssSelector(".selected");
	private By ActiveTab = By.cssSelector(".filters > li:nth-of-type(2) > a");
	
	public AddTaskToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Add-Launch the To Do List URL$")
	public void launch_the_ToDoList_URL() throws IOException, InterruptedException {
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Add-User enters a Task \"([^\"]*)\" and click enter$")
	public void add_User_enters_a_Task_and_click_enter(String task) throws IOException, InterruptedException {
		
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(task);
		WebElement textbox = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox.sendKeys(Keys.ENTER);
		SharedResource wait = new SharedResource();
		wait.waitElement();

	}

	@Then("^Add-Check whether the Task is added to To Do List$")
	public void Check_whether_the_Task_is_added_to_ToDo_List() throws IOException, InterruptedException {
		readPropertyFile = new ReadPropertyFile();
		WebElement Taskvalue = driver.findElement(TaskValue);
		Taskvalue.getText();
		String TaskValidation = Taskvalue.getText();
		System.out.println("The Taskvalue:" + TaskValidation);
		Assert.assertEquals(TaskValidation, readPropertyFile.getTaskValue());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@And("^Add-Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_added_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@Then("^Close the AddTask browser$")
	public void close_the_browser() {
		driver.quit();
	}
}
