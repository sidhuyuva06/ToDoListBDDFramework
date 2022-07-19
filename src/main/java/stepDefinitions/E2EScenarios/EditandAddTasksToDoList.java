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

public class EditandAddTasksToDoList {

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
	public EditandAddTasksToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Edit&Add-Launch the To Do List URL$")
	public void launch_the_ToDoList_URL() throws IOException, InterruptedException {
		//Launch the To Do List URL
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Edit&Add-User enters two Tasks \\\"(.*)\\\",\\\"(.*)\\\"and click enter$")
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
	@And("^Edit&Add-Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_added_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		// Click on the All Tab and Active Tab
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Edit&Add-Double click on the Added Task, edit the task\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\"and click enter$")
	public void edit_Double_click_on_the_Added_Task_edit_the_task_and_click_enter(String EditTask1, String EditTask2) throws Throwable {
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
	@Then("^Edit&Add-User enters two more Tasks\\\"(.*)\\\",\\\"(.*)\\\"and click enter$")
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
	@Then("^Edit&Add-Close the Editing&AddingTask browser$")
	public void close_the_browser() {
		//Close the browser
		driver.quit();
	}
}
