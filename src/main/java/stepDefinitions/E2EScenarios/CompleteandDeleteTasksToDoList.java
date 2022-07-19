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
import utils.ReadPropertyFile;
import utils.SharedResource;



public class CompleteandDeleteTasksToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By Completioncheckbox1=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/input[@type='checkbox']");
	private By Completioncheckbox2=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[2]/div[@class='view']/input[@type='checkbox']");
	private By Completioncheckbox3=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[3]/div[@class='view']/input[@type='checkbox']");
	private By CompletedTab = By.xpath("//body[@class='learn-bar']/section[@class='todoapp']//ul[@class='filters']//a[@href='#/completed']");
	private By ClearCompleted=By.cssSelector(".clear-completed");
	private By deletebutton=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/button[@class='destroy']");
	private By ToDoListDropdown=By.xpath("//section[@class='todoapp']/section[@class='main']/label[.='Mark all as complete']");
	public CompleteandDeleteTasksToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Complete&Delete-Launch the To Do List URL$")
	public void completeDelete_Launch_the_To_Do_List_URL() throws IOException, InterruptedException  {
	    // Launch the To Do List URL
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Complete&Delete-User enters a Task \"([^\"]*)\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\" and click enter$")
	public void completeDelete_User_enters_a_Task_and_click_enter(String CompletingTask1, String CompletingTask2, String CompletingTask3 ) throws InterruptedException  {
		//CompletingTask1
		SharedResource wait = new SharedResource();
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(CompletingTask1);
		WebElement textbox1 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox1.sendKeys(Keys.ENTER);
		wait.waitElement();
		//CompletingTask2
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(CompletingTask2);
		WebElement textbox2 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox2.sendKeys(Keys.ENTER);
		wait.waitElement();
		//CompletingTask3
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(CompletingTask3);
		WebElement textbox3 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox3.sendKeys(Keys.ENTER);
		wait.waitElement();
	}

	@Then("^Complete&Delete-Task complete by clicking on RadioButton before the task$")
	public void completeDelete_Task_complete_by_clicking_on_RadioButton_before_the_task()  {
		// Complete check box click for all the three tasks
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox2).click();
	   driver.findElement(Completioncheckbox3).click();
	}
	

	@Then("^Complete&Delete-Click on the Completion tab and validate the task availability$")
	public void complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
		// Click on Complete Tab
		driver.findElement(CompletedTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Complete&Delete-Delete two tasks by click on close button at the end of the task$")
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
	@Then("^Complete&Delete-Validate whether the reamining non deleted task is available by clicking on ToDoListDropDown$")
	public void validate_non_deleted_Task_by_clicking_on_ToDoListDropdown() throws InterruptedException {
		//To minimize and maximize the Drop Down to check the remaining Deleted Task
		SharedResource wait = new SharedResource();
		driver.findElement(ToDoListDropdown).click();
		wait.waitElement();
		driver.findElement(ToDoListDropdown).click();
		wait.waitElement();
	}
	@Then("^Complete&Delete-Click on Clear Completed$")
	public void complete_Click_on_Clear_Completed() throws InterruptedException{
		// Click on Clear Completed
		driver.findElement(ClearCompleted).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
}
	@Then("^Complete&Delete-Close the CompleteTask browser$")
	public void close_the_browser() {
		//Close the browser
		driver.quit();
	}
}