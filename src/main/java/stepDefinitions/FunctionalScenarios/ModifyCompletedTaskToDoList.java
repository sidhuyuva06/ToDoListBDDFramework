package stepDefinitions.FunctionalScenarios;

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



public class ModifyCompletedTaskToDoList {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By Completioncheckbox=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='checkbox']");
	public ModifyCompletedTaskToDoList(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^ModifyCompletedTask-Launch the To Do List URL$")
	public void complete_Launch_the_To_Do_List_URL() throws IOException, InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^ModifyCompletedTask-User enters a Task \\\"([^\\\"]*)\\\" and click enter$")
	public void complete_User_enters_a_Task_and_click_enter(String ModifyCompletingTask) throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(ModifyCompletingTask);
		WebElement textbox = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox.sendKeys(Keys.ENTER);
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@Then("^ModifyCompletedTask-Task complete by clicking on RadioButton before the task$")
	public void complete_Task_complete_by_clicking_on_RadioButton_before_the_task() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(Completioncheckbox).click();
	   SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	

	@Then("^ModifyCompletedTask-Click on the RadioButton again to change into NonCompleted task$")
	public void complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(Completioncheckbox).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	
	
	@Then("^Close the ModifyCompletedTask browser$")
	public void close_the_browser() {
		driver.quit();
	}
}