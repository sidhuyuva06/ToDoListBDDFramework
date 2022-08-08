Feature: Managing To Do List for Functional Scenarios
@FunctionalScenarios 
  Scenario Outline: Add a Task in ToDo List
    Given Launch the To Do List URL
    When  User enters a Task "<Task>" and click enter
    Then  Check whether the Task is added to To Do List
    And   Validate whether the added Task is available in All and Available tab
    Then  Close the browser

	  Examples: 
    |Task        |
    |Requirements|
		
@FunctionalScenarios
Scenario Outline: Complete a Task from ToDo List
    
    Given Launch the To Do List URL
    When  User enters a Task "<CompletingTask>" and click enter
    Then  Task complete by clicking on RadioButton before the task
    And   Click on the Completion tab and validate the task availability
    And   Check whether completed task is crossed with a tick sign 
    And   Click on Clear Completed
    Then  Close the browser
    Examples: 
    |CompletingTask|
    |TestPlanning  |
@FunctionalScenarios    
Scenario Outline: Add and Delete a Task in ToDo List
    
    Given Launch the To Do List URL
    When  User enters a Task "<Task1>" and click enter
    And   Validate whether the added Task is available in All and Available tab
    Then  Delete the task by click on close button at the end of the task
    Then  Close the browser

	  Examples: 
    |Task1       |
    |DeleteTask1 |
@FunctionalScenarios
Scenario Outline: Edit a Task in ToDo List
    Given Launch the To Do List URL
    When  User enters a Task "<Task>" and click enter
    Then  Double click on the Added Task, edit the task"<EditTask>"and click enter
    And   Close the browser

	  Examples: 
    |Task     |EditTask |
    |UserStory|Gromming |
@FunctionalScenarios
Scenario: To Do List Login Test Scenario

     Given user is already on Login Page
     When title of login page is Vue.js • TodoMVC
     Then Close the browser
@FunctionalScenarios
Scenario Outline: Modify a task from Completed to Non Completed from ToDo List
    
    Given Launch the To Do List URL
    When  User enters a Task "<ModifyCompletingTask>" and click enter
    Then  Task complete by clicking on all the RadioButtons available before the task
    And   Click on the RadioButton again to change into NonCompleted task
    Then  Close the browser
    Examples: 
    |ModifyCompletingTask|
    |TestExecution       |
		
		
