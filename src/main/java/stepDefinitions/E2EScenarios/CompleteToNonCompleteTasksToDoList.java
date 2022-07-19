package stepDefinitions.E2EScenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import utils.ReadPropertyFile;
import utils.SharedResource;



public class CompleteToNonCompleteTasksToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By Completioncheckbox1=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/input[@type='checkbox']");
	private By Completioncheckbox2=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[2]/div[@class='view']/input[@type='checkbox']");
	private By Completioncheckbox3=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[3]/div[@class='view']/input[@type='checkbox']");
	private By CompletedTab = By.xpath("//body[@class='learn-bar']/section[@class='todoapp']//ul[@class='filters']//a[@href='#/completed']");
	private By AllTab = By.cssSelector(".selected");
	private By ActiveTab = By.cssSelector(".filters > li:nth-of-type(2) > a");
	public CompleteToNonCompleteTasksToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^CompleteToNonComplete-Launch the To Do List URL$")
	public void complete_Launch_the_To_Do_List_URL() throws IOException, InterruptedException  {
	    // Launch the To Do List URL
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^CompleteToNonComplete-User enters a Task \"([^\"]*)\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\" and click enter$")
	public void complete_User_enters_a_Task_and_click_enter(String CompletingTask1, String CompletingTask2, String CompletingTask3 ) throws InterruptedException  {
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

	@Then("^CompleteToNonComplete-Task complete by clicking on RadioButton before the task$")
	public void complete_Task_complete_by_clicking_on_RadioButton_before_the_task()  {
	    // Clicking on the Completion check box to complete the tasks
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox2).click();
	   driver.findElement(Completioncheckbox3).click();
	}
	@And("^CompleteToNonComplete-Click on the Completion tab and validate the task availability$")
	public void complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
	    // Click on the Completed Tab
		driver.findElement(CompletedTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	
	@Then("^CompleteToNonComplete-Task Make it as Non-Complete by clicking on RadioButton again before the task$")
	public void complete_Task_Noncomplete_by_clicking_on_RadioButton_before_the_task()  {
	    // Clicking on the Completion check box again to non complete the tasks
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox1).click();
	}
	@Then("^CompleteToNonComplete-Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_addedNew_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		// Click on the All Tab and Active Tab
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	
	@Then("^CompleteToNonComplete-Close the CompleteToNonCompleteTask browser$")
	public void close_the_browser() {
		//Close the browser
		driver.quit();
	}
}