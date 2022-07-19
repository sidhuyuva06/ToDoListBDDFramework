package stepDefinitions.E2EScenarios;

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

public class AddandDeleteTasksToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	WebElement TextBoxClick;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By AllTab = By.cssSelector(".selected");
	private By ActiveTab = By.cssSelector(".filters > li:nth-of-type(2) > a");
	private By deletebutton=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/button[@class='destroy']");
	private By ToDoListDropdown=By.xpath("//section[@class='todoapp']/section[@class='main']/label[.='Mark all as complete']");
	
	public AddandDeleteTasksToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Add&Delete-Launch the To Do List URL$")
	public void launch_the_ToDoList_URL() throws IOException, InterruptedException {
		//Launch the To Do List URL
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Add&Delete-User enters a Task \\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\" and click enter$")
	public void add_User_enters_a_Task_and_click_enter(String DeleteTask1,String DeleteTask2,String DeleteTask3) throws IOException, InterruptedException {
		//AddTask1
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(DeleteTask1);
		WebElement textbox1 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox1.sendKeys(Keys.ENTER);
		SharedResource wait = new SharedResource();
		wait.waitElement();
		//AddTask2
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(DeleteTask2);
		WebElement textbox2 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox2.sendKeys(Keys.ENTER);
		wait.waitElement();
		//AddTask3
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(DeleteTask3);
		WebElement textbox3 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox3.sendKeys(Keys.ENTER);
		wait.waitElement();

	}
	@And("^Add&Delete-Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_added_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		//Validate the added Task in All tab and Active tab
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Add&Delete-Delete two tasks by click on close button at the end of the task$")
	public void Delete_two_tasks_by_click_on_close_button_at_the_end_of_the_task() throws InterruptedException {
		SharedResource wait = new SharedResource();
		//Delete Task1
		WebElement DeleteTask1 = driver.findElement(deletebutton);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", DeleteTask1);
        wait.waitElement();
    	//Delete Task2
		WebElement DeleteTask2 = driver.findElement(deletebutton);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", DeleteTask2);
        wait.waitElement();
	}
	@Then("^Add&Delete-Click on the ToDoListDropDown to check the remaining non-deleted task$")
	public void Click_on_the_ToDoListDropDown_ToCheck_remaining_nondeletedtask() throws InterruptedException	{
	//To minimize the Drop Down
	SharedResource wait = new SharedResource();
	driver.findElement(ToDoListDropdown).click();
	wait.waitElement();
	//To maximize the Drop Down
	driver.findElement(ToDoListDropdown).click();
	wait.waitElement();
}
 
	@Then("^Close the Add&DeleteTask browser$")
	public void close_the_browser() {
		//Close the browser
		driver.quit();
	}
}
