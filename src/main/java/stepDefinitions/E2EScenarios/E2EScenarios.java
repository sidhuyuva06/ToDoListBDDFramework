package stepDefinitions.E2EScenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ReadPropertyFile;
import utils.SharedResource;



public class E2EScenarios {

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
	private By Completioncheckbox=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/input[@type='checkbox']");
	private By deletebutton=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/button[@class='destroy']");
	private By ToDoListDropdown=By.xpath("//section[@class='todoapp']/section[@class='main']/label[.='Mark all as complete']");
	private By Editvalue1=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='UserStory']");
	private By Editvalue2=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='TestPlanning']");
	private By NewValue1=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='text']");
	private By NewValue2=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[2]/input[@type='text']");
	public E2EScenarios(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	

	@When("^User enters a Task \"([^\"]*)\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\" and click enter$")
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
	@Then("^Complete two tasks by clicking on RadioButton before the task$")
	public void CompleteEdit_tasks_by_click_on_Radio_button_before_the_task() throws InterruptedException {
		SharedResource wait = new SharedResource(); 
		   //First Task Completion
		   driver.findElement(Completioncheckbox).click();
		   wait.waitElement();
		  //Second Task Completion
		   driver.findElement(Completioncheckbox).click();
		   wait.waitElement();
	}
	@Then("^Complete four tasks by clicking on RadioButton before the task$")
	public void Complete_tasks_by_click_on_Radio_button_before_the_task() throws InterruptedException {
		SharedResource wait = new SharedResource(); 
		   //First Task Completion
		   driver.findElement(Completioncheckbox).click();
		   wait.waitElement();
		  //Second Task Completion
		   driver.findElement(Completioncheckbox).click();
		   wait.waitElement();
		  //Third Task Completion
		   driver.findElement(Completioncheckbox).click();
		   wait.waitElement();
		  //Fourth Task Completion
		   driver.findElement(Completioncheckbox).click();
		   wait.waitElement();
	}
	@Then("^Task complete by clicking on all RadioButtons before the task$")
	public void complete_Task_complete_by_clicking_on_RadioButton_before_the_task()  {
	    // Click on Completion Check box for all the three tasks
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox2).click();
	   driver.findElement(Completioncheckbox3).click();
	}
	
	@Then("^Make three tasks as Non-Complete by clicking on RadioButton again before the task$")
	public void complete_Task_Noncomplete_by_clicking_on_RadioButton_before_the_task()  {
	    // Clicking on the Completion check box again to non complete the tasks
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox1).click();
	   driver.findElement(Completioncheckbox1).click();
	}

	@When("^User adds Tasks \"([^\"]*)\",\\\"([^\\\"]*)\\\" and click enter$")
	public void complete_User_adds_Task_and_click_enter(String AddedTask1, String AddedTask2) throws InterruptedException  {
		//AddedTask1
		SharedResource wait = new SharedResource();
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(AddedTask1);
		WebElement textbox1 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox1.sendKeys(Keys.ENTER);
		wait.waitElement();
		//AddedTask2
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(AddedTask2);
		WebElement textbox2 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox2.sendKeys(Keys.ENTER);
		wait.waitElement();
	}
	@Then("^Delete two tasks by click on close button at the end of the task$")
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
	@Then("^Click on the ToDoListDropDown to check the remaining non-deleted task$")
	public void Click_on_the_ToDoListDropDown_ToCheck_remaining_nondeletedtask() throws InterruptedException	{
	//To minimize the Drop Down
	SharedResource wait = new SharedResource();
	driver.findElement(ToDoListDropdown).click();
	wait.waitElement();
	//To maximize the Drop Down
	driver.findElement(ToDoListDropdown).click();
	wait.waitElement();
}
	@When("^User enters four Tasks \\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\"  and click enter$")
	public void add_User_enters_4_Tasks_and_click_enter(String Task1,String Task2, String Task3, String Task4) throws IOException, InterruptedException {
		SharedResource wait = new SharedResource();
		//Entering Task 1
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task1);
		WebElement textbox1 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox1.sendKeys(Keys.ENTER);
		wait.waitElement();
		//Entering Task 2
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task2);
		WebElement textbox2 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox2.sendKeys(Keys.ENTER);
		wait.waitElement();
		//Entering Task 3
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task3);
		WebElement textbox3 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox3.sendKeys(Keys.ENTER);
		wait.waitElement();
		//Entering Task 4
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task4);
		WebElement textbox4 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox4.sendKeys(Keys.ENTER);
		wait.waitElement();
	}
	@Then("^Double click on the Added Task, edit the task\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\"and click enter$")
	public void edit_Double_click_on_the_Added_Task_edit_the_task_and_click_enter(String EditTask1, String EditTask2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		SharedResource wait = new SharedResource();
		//Edit FirstTask
		Actions act = new Actions(driver);
		WebElement EditTaskvalue1= driver.findElement(Editvalue1);
		act.doubleClick(EditTaskvalue1).perform();
		driver.findElement(NewValue1).sendKeys(EditTask1);
		wait.waitElement();
		//Edit Second Task
		WebElement EditTaskvalue2= driver.findElement(Editvalue2);
		act.doubleClick(EditTaskvalue2).perform();
		driver.findElement(NewValue2).sendKeys(EditTask2);
		wait.waitElement();
		
	}
	@Then("^Validate the edited tasks are available by clicking on the ToDoListDropdown$")
	public void Validate_the_edited_tasks_are_available_by_clicking_on_the_ToDoListDropdown() throws InterruptedException {
		//To minimize the Drop Down
		SharedResource wait = new SharedResource();
		driver.findElement(ToDoListDropdown).click();
		wait.waitElement();
		//To maximize the Drop Down
		driver.findElement(ToDoListDropdown).click();
		wait.waitElement();
	}
	@When("^User enters two Tasks \\\"(.*)\\\",\\\"(.*)\\\"and click enter$")
	public void add_User_enters_2_Tasks_and_click_enter(String Task1,String Task2) throws IOException, InterruptedException {
		SharedResource wait = new SharedResource();
		//Entering Task 1
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task1);
		WebElement textbox1 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox1.sendKeys(Keys.ENTER);
		wait.waitElement();
		//Entering Task 2
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task2);
		WebElement textbox2 = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox2.sendKeys(Keys.ENTER);
		wait.waitElement();
	}
	@Then("^Validate whether the reamining non deleted task is available by clicking on ToDoListDropDown$")
	public void validate_non_deleted_Task_by_clicking_on_ToDoListDropdown() throws InterruptedException {
		//To minimize and maximize the Drop Down to check the remaining Deleted Task
		SharedResource wait = new SharedResource();
		driver.findElement(ToDoListDropdown).click();
		wait.waitElement();
		driver.findElement(ToDoListDropdown).click();
		wait.waitElement();
	}
	@Then("^User enters two more Tasks\\\"(.*)\\\",\\\"(.*)\\\"and click enter$")
	public void Edit_add_User_enters_2more_Tasks_and_click_enter(String Task3,String Task4) throws IOException, InterruptedException {
		SharedResource wait = new SharedResource();
		        //Entering Task 3
				driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task3);
				WebElement textbox3 = driver.findElement(WhatNeedsToBeDoneTextBox);
				textbox3.sendKeys(Keys.ENTER);
				wait.waitElement();
				//Entering Task 4
				driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(Task4);
				WebElement textbox4 = driver.findElement(WhatNeedsToBeDoneTextBox);
				textbox4.sendKeys(Keys.ENTER);
				wait.waitElement();
	}
	@Then("^Double click on the Completed Task, edit the task\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\"and click enter$")
	public void Double_click_on_the_Added_Task_edit_the_task_and_click_enter(String EditTask1, String EditTask2) throws Throwable {
		SharedResource wait = new SharedResource();
		//Edit FirstTask
		Actions act = new Actions(driver);
		WebElement EditTaskvalue1= driver.findElement(Editvalue1);
		act.doubleClick(EditTaskvalue1).perform();
		driver.findElement(NewValue1).sendKeys(EditTask1);
		driver.findElement(NewValue1).sendKeys(Keys.ENTER);
		wait.waitElement();
		//Edit Second Task
		WebElement EditTaskvalue2= driver.findElement(Editvalue2);
		act.doubleClick(EditTaskvalue2).perform();
		driver.findElement(NewValue2).sendKeys(EditTask2);
		driver.findElement(NewValue2).sendKeys(Keys.ENTER);
		wait.waitElement();
		
	}

}