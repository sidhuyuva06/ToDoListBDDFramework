package stepDefinitions.FunctionalScenarios;

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


public class EditTaskToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By Editvalue=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='UserStory']");
	private By NewValue=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='text']");
	public EditTaskToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Edit-Launch the To Do List URL$")
	public void edit_Launch_the_To_Do_List_URL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();   
	}

	@When("^Edit-User enters a Task \"([^\"]*)\" and click enter$")
	public void edit_User_enters_a_Task_and_click_enter(String task) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(task);
		WebElement textbox = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox.sendKeys(Keys.ENTER);
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@Then("^Edit-Double click on the Added Task, edit the task\\\"([^\\\"]*)\\\"and click enter$")
	public void edit_Double_click_on_the_Added_Task_edit_the_task_and_click_enter(String EditTask) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Actions act = new Actions(driver);
		WebElement EditTaskvalue= driver.findElement(Editvalue);
		act.doubleClick(EditTaskvalue).perform();
		driver.findElement(NewValue).sendKeys(EditTask);
		SharedResource wait = new SharedResource();
		wait.waitElement();
		
	}
	@Then("^Close the EditTask browser$")
	public void close_the_browser() {
		driver.quit();
	}
}
