package stepDefinitions.FunctionalScenarios;

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
import junit.framework.Assert;
import utils.ReadPropertyFile;
import utils.SharedResource;

public class FunctionalScenarios {

	WebDriver driver;
	ReadPropertyFile readPropertyFile;
	WebElement TextBoxClick;
	private By WhatNeedsToBeDoneTextBox = By.cssSelector(".new-todo");
	private By TaskValue = By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='Requirements']");
	private By AllTab = By.cssSelector(".selected");
	private By ActiveTab = By.cssSelector(".filters > li:nth-of-type(2) > a");
	private By Completioncheckbox=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='checkbox']");
	private By CompletedTab = By.xpath("//body[@class='learn-bar']/section[@class='todoapp']//ul[@class='filters']//a[@href='#/completed']");
	private By CrossCompletionTask=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='TestPlanning']");
	private By CompletionTickSign=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='checkbox']");
	private By ClearCompleted=By.cssSelector(".clear-completed");
	private By deletebutton=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']/li[1]/div[@class='view']/button[@class='destroy']");
	private By Editvalue=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//label[.='UserStory']");
	private By NewValue=By.xpath("//section[@class='todoapp']/section[@class='main']/ul[@class='todo-list']//input[@type='text']");
	public FunctionalScenarios(SharedResource sharedResource) throws InterruptedException {
		this.driver = sharedResource.init();
	}
	@Given("^Launch the To Do List URL$")
	public void launch_the_ToDoList_URL() throws IOException, InterruptedException {
		readPropertyFile = new ReadPropertyFile();
		driver.get(readPropertyFile.getTodoListURL());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@When("^User enters a Task \"([^\"]*)\" and click enter$")
	public void add_User_enters_a_Task_and_click_enter(String task) throws IOException, InterruptedException {
		
		driver.findElement(WhatNeedsToBeDoneTextBox).sendKeys(task);
		WebElement textbox = driver.findElement(WhatNeedsToBeDoneTextBox);
		textbox.sendKeys(Keys.ENTER);
		SharedResource wait = new SharedResource();
		wait.waitElement();

	}

	@Then("^Check whether the Task is added to To Do List$")
	public void Check_whether_the_Task_is_added_to_ToDo_List() throws IOException, InterruptedException {
		readPropertyFile = new ReadPropertyFile();
		WebElement Taskvalue = driver.findElement(TaskValue);
		Taskvalue.getText();
		String TaskValidation = Taskvalue.getText();
		System.out.println("The Taskvalue:" + TaskValidation);
		Assert.assertEquals(TaskValidation, readPropertyFile.getTaskValue());
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@And("^Validate whether the added Task is available in All and Available tab$")
	public void Validate_whether_the_added_Task_is_available_in_All_and_Available_tab() throws InterruptedException {
		driver.findElement(AllTab).click();
		driver.findElement(ActiveTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@Then("^Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

	@Then("^Task complete by clicking on RadioButton before the task$")
	public void complete_Task_complete_by_clicking_on_RadioButton_before_the_task()  {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(Completioncheckbox).click();
	}
	
	@Then("^Click on the RadioButton again to change into NonCompleted task$")
	public void modify_complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(Completioncheckbox).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}

	@Then("^Click on the Completion tab and validate the task availability$")
	public void complete_Click_on_the_Completion_tab_and_validate_the_task_availability() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(CompletedTab).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	
	@Then("^Check whether completed task is crossed with a tick sign$")
	public void complete_Check_whether_completed_task_is_crossed_with_a_tick_sign() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		boolean CrossedCompletionTask=driver.findElement(CrossCompletionTask).isDisplayed();
		boolean CompletedTickSign= driver.findElement(CompletionTickSign).isDisplayed();
		SharedResource wait = new SharedResource();
		wait.waitElement();
	}
	@Then("^Click on Clear Completed$")
	public void complete_Click_on_Clear_Completed() throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(ClearCompleted).click();
		SharedResource wait = new SharedResource();
		wait.waitElement();
}
	@Then("^Delete the task by click on close button at the end of the task$")
	public void Delete_the_task_by_click_on_close_button_at_the_end_of_the_task() throws InterruptedException {
		SharedResource wait = new SharedResource();
		WebElement Deletebutton = driver.findElement(deletebutton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Deletebutton);
        
       // js.executeScript("arguments[0].onmouseover()", Deletebutton);
        wait.waitElement();
	}

	@Then("^Double click on the Added Task, edit the task\\\"([^\\\"]*)\\\"and click enter$")
	public void edit_Double_click_on_the_Added_Task_edit_the_task_and_click_enter(String EditTask) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Actions act = new Actions(driver);
		WebElement EditTaskvalue= driver.findElement(Editvalue);
		act.doubleClick(EditTaskvalue).perform();
		driver.findElement(NewValue).sendKeys(EditTask);
		SharedResource wait = new SharedResource();
		wait.waitElement();
		
	}
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page() throws IOException, InterruptedException{
		 
	 //System.setProperty("webdriver.chrome.driver","src/main/java/chromedriver.exe");
	 //driver = new ChromeDriver();
	 readPropertyFile = new ReadPropertyFile();
	 driver.get(readPropertyFile.getTodoListURL());
	 SharedResource wait = new SharedResource();
	 wait.waitElement();
	 }
	
	
	 @When("^title of login page is Vue.js • TodoMVC$")
	 public void title_of_login_page_Vue_js_TodoMVC() throws InterruptedException{
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Vue.js • TodoMVC", title);
	 SharedResource wait = new SharedResource();
     wait.waitElement();
	 }


	
		

	
}
