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
import utils.ReadPropertyFile;
import utils.SharedResource;



public class CompleteTaskToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By Completioncheckbox=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='checkbox']");
	private By CompletedTab = By.xpath("//body[@class='learn-bar']/section[@class='todoapp']//ul[@class='filters']//a[@href='#/completed']");
	private By CrossCompletionTask=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='TestPlanning']");
	private By CompletionTickSign=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='checkbox']");
	private By ClearCompleted=By.cssSelector(".clear-completed");
	public CompleteTaskToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Complete-Launch the To Do List URL$")
	public void complete_Launch_the_To_Do_List_URL() throws IOException, InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^Complete-User enters a Task \"([^\"]*)\" and click enter$")
	public void complete_User_enters_a_Task_and_click_enter(String CompletingTask) throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(CompletingTask);
		WebElement textbox = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox.sendKeys(Keys.ENTER);
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@Then("^Complete-Task complete by clicking on RadioButton before the task$")
	public void complete_Task_complete_by_clicking_on_RadioButton_before_the_task()  {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(Completioncheckbox).click();
	}
	

	@Then("^Complete-Click on the Completion tab and validate the task availability$")
	public void complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(CompletedTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	
	@Then("^Complete-Check whether completed task is crossed with a tick sign$")
	public void complete_Check_whether_completed_task_is_crossed_with_a_tick_sign() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		boolean CrossedCompletionTask=driver.findElement(CrossCompletionTask).isDisplayed();
		boolean CompletedTickSign= driver.findElement(CompletionTickSign).isDisplayed();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Complete-Click on Clear Completed$")
	public void complete_Click_on_Clear_Completed() throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(ClearCompleted).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
}
	@Then("^Close the CompleteTask browser$")
	public void close_the_browser() {
		driver.quit();
	}
}