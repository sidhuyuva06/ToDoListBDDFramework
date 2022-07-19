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
import io.cucumber.java.en.And;
import utils.ReadPropertyFile;
import utils.SharedResource;

public class EditandDeleteTasksToDoList {

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
	private By deletebutton=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/button[@class='destroy']");
	
	public EditandDeleteTasksToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Edit&Delete-Launch the To Do List URL$")
	//Launch the To Do List URL
	public void launch_the_ToDoList_URL() throws IOException, InterruptedException {
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Edit&Delete-User enters four Tasks \\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\",\\\"(.*)\\\"  and click enter$")
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
	@And("^Edit&Delete-Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_added_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		// Click on the All Tab and Active Tab
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Edit&Delete-Double click on the Added Task, edit the task\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\"and click enter$")
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
	@Then("^Edit&Delete-Delete two tasks by click on close button at the end of the task$")
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
	@Then("^Close the Editing&DeletingTask browser$")
	public void close_the_browser() {
		//Close the browser
		driver.quit();
	}
}
