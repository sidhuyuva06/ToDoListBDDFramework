package stepDefinitions.E2EScenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadPropertyFile;
import utils.SharedResource;



public class AddandCompleteTasksToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By Completioncheckbox1=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/input[@type='checkbox']");
	private By Completioncheckbox2=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[2]/div[@class='view']/input[@type='checkbox']");
	private By Completioncheckbox3=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[3]/div[@class='view']/input[@type='checkbox']");
	private By CompletedTab = By.xpath("//body[@class='learn-bar']/section[@class='todoapp']//ul[@class='filters']//a[@href='#/completed']");
	private By CrossCompletionTask=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='TestPlanning']");
	private By CompletionTickSign=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='checkbox']");
	private By ClearCompleted=By.cssSelector(".clear-completed");
	public AddandCompleteTasksToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Add&Complete-Launch the To Do List URL$")
	public void complete_Launch_the_To_Do_List_URL() throws IOException, InterruptedException  {
	    // Launch the To Do List URL
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Add&Complete-User enters a Task \"([^\"]*)\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\" and click enter$")
	public void complete_User_enters_a_Task_and_click_enter(String CompletingTask1, String CompletingTask2, String CompletingTask3 ) throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
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

	@Then("^Add&Complete-Task complete by clicking on RadioButton before the task$")
	public void complete_Task_complete_by_clicking_on_RadioButton_before_the_task()  {
	    // Click on Completion Check box for all the three tasks
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox2).click();
	   driver.findElement(Completioncheckbox3).click();
	}
	

	@Then("^Add&Complete-Click on the Completion tab and validate the task availability$")
	public void complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
	    // Click on the Completion Tab
		driver.findElement(CompletedTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Add&Complete-Check whether completed task is crossed with a tick sign$")
	public void complete_Check_whether_completed_task_is_crossed_with_a_tick_sign() throws InterruptedException {
	    // Validating the CrossCompletionTask and COmpletionTick Sign
		driver.findElement(CrossCompletionTask).isDisplayed();
		driver.findElement(CompletionTickSign).isDisplayed();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Add&Complete-Click on Clear Completed$")
	public void complete_Click_on_Clear_Completed() throws InterruptedException{
	    // Click on Clear Completed
		driver.findElement(ClearCompleted).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
}
	@Then("^Add&Complete-Close the CompleteTask browser$")
	public void close_the_browser() {
		//Close the browser
		driver.quit();
	}
}