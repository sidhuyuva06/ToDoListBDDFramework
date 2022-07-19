package stepDefinitions.E2EScenarios;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import utils.ReadPropertyFile;
import utils.SharedResource;

public class EditandCompleteTasksToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	WebElement TextBoxClick;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By AllTab = By.cssSelector(".selected");
	private By ActiveTab = By.cssSelector(".filters > li:nth-of-type(2) > a");
	private By Editvalue1=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='UserStory']");
	private By Editvalue2=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='TestPlanning']");
	private By NewValue1=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='text']");
	private By NewValue2=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[2]/input[@type='text']");
	private By Completioncheckbox=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/input[@type='checkbox']");
	private By CompletedTab = By.xpath("//body[@class='learn-bar']/section[@class='todoapp']//ul[@class='filters']//a[@href='#/completed']");
	private By ClearCompleted=By.cssSelector(".clear-completed");
	public EditandCompleteTasksToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Edit&Complete-Launch the To Do List URL$")
	public void launch_the_ToDoList_URL() throws IOException, InterruptedException {
		//Launch the To Do List URL
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Edit&Complete-User enters four Tasks \\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\"  and click enter$")
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
	@And("^Edit&Complete-Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_added_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		// Click on the All Tab and Active Tab
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Edit&Complete-Double click on the Added Task, edit the task\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\"and click enter$")
	public void edit_Double_click_on_the_Added_Task_edit_the_task_and_click_enter(String EditTask1, String EditTask2) throws Throwable {
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
	@Then("^Edit&Complete-Task complete by clicking on RadioButton before the task$")
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
	@And("^Edit&Complete-Click on the Completion tab and validate the task availability$")
	public void complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
	    // Click on the Complete Tab
		driver.findElement(CompletedTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Edit&Complete-Click on Clear Completed$")
	public void complete_Click_on_Clear_Completed() throws InterruptedException{
		 // Click on the Clear Completed
		driver.findElement(ClearCompleted).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
}
	@Then("^Edit&Complete-Close the Editing&CompleteTask browser$")
	public void close_the_browser() {
		// Close the browser
		driver.quit();
	}
}
