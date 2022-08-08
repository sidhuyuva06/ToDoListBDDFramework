Feature: Managing To Do List for E2E Scenarios
@E2E
 Scenario Outline: Adding three tasks and Complete them using ToDo List
 
    Given Launch the To Do List URL
    When  User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  Task complete by clicking on all RadioButtons before the task
    And   Click on the Completion tab and validate the task availability
    Then  Check whether completed task is crossed with a tick sign 
    And   Click on Clear Completed
    Then  Close the browser
    
    
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|
    |UserStoryGrooming|TestPlanning   |Test Automation |
@E2E    
Scenario Outline: Adding three tasks and Deleting two Tasks from ToDo List
  
    Given Launch the To Do List URL
    When  User enters a Task "<Task1>","<Task2>","<Task3>" and click enter
    And   Validate whether the added Task is available in All and Available tab
    Then  Delete two tasks by click on close button at the end of the task
    Then  Click on the ToDoListDropDown to check the remaining non-deleted task
    Then  Close the browser

	  Examples: 
    |Task1       |Task2       |Task3           |
    |Requirement |TestPlanning|TestCaseCreation|
@E2E    
Scenario Outline: Adding four tasks and Editing two Tasks in ToDo List
  
    Given Launch the To Do List URL
    When  User enters four Tasks "<Task1>","<Task2>","<Task3>","<Task4>"  and click enter
    Then  Validate whether the added Task is available in All and Available tab
    And   Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Validate the edited tasks are available by clicking on the ToDoListDropdown
    Then  Close the browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|
@E2E    
Scenario Outline: Completing three Tasks and Adding two Tasks to ToDo List
 
    Given Launch the To Do List URL
    When  User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  Task complete by clicking on all RadioButtons before the task
    And   Click on the Completion tab and validate the task availability
    And   Click on Clear Completed
    Then  User adds Tasks "<AddTask1>","<AddTask2>" and click enter
    Then  Validate whether the added Task is available in All and Available tab
    Then  Close the browser
   
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|AddTask1     |AddTask2     |
    |UserStoryGrooming|TestPlanning   |Test Automation |TestExecution|TestReporting|
@E2E   
Scenario Outline: Completing three tasks and Deleting two tasks from ToDo List
 
    Given Launch the To Do List URL
    When  User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  Task complete by clicking on all RadioButtons before the task
    And   Click on the Completion tab and validate the task availability
    And   Delete two tasks by click on close button at the end of the task
    And   Validate whether the reamining non deleted task is available by clicking on ToDoListDropDown
    Then  Close the browser
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|
    |UserStoryGrooming|TestPlanning   |Test Automation |
@E2E    
Scenario Outline: Completing two tasks and Editing two Tasks in ToDo List
   
    Given Launch the To Do List URL
    When  User enters two Tasks "<Task1>","<Task2>"and click enter
    Then  Validate whether the added Task is available in All and Available tab
    Then  Complete two tasks by clicking on RadioButton before the task
    And   Click on the Completion tab and validate the task availability
    And   Double click on the Completed Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Click on Clear Completed
    Then  Close the browser

	  Examples: 
    |Task1    |Task2       |EditTask1|EditTask2        |
    |UserStory|TestPlanning|&Grooming|&TestcaseCreation|
@E2E    
Scenario Outline: Completing three Tasks and changing back to non completed tasks in ToDo List
 
    Given Launch the To Do List URL
    When  User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  Task complete by clicking on all RadioButtons before the task
    And   Click on the Completion tab and validate the task availability
    And   Make three tasks as Non-Complete by clicking on RadioButton again before the task
    Then  Validate whether the added Task is available in All and Available tab
    Then  Close the browser
   
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|
    |UserStoryGrooming|TestPlanning   |Test Automation |
@E2E    
Scenario Outline: Editing two tasks and Adding two tasks in ToDo List
   
    Given Launch the To Do List URL
    When  User enters two Tasks "<Task1>","<Task2>"and click enter
    Then  Validate whether the added Task is available in All and Available tab
    And   Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  User enters two more Tasks"<Task3>","<Task4>"and click enter
    Then  Close the browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|
@E2E    
Scenario Outline: Editing two tasks from four added tasks and completing all the tasks in ToDo List
    
    Given Launch the To Do List URL
    When  User enters four Tasks "<Task1>","<Task2>","<Task3>","<Task4>"  and click enter
    Then  Validate whether the added Task is available in All and Available tab
    And   Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Complete four tasks by clicking on RadioButton before the task
    And   Click on the Completion tab and validate the task availability
    Then  Click on Clear Completed
    Then  Close the browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|
@E2E    
Scenario Outline: Editing two tasks from the added four tasks and Deleting two Tasks from ToDo List
    
    Given Launch the To Do List URL
    When  User enters four Tasks "<Task1>","<Task2>","<Task3>","<Task4>"  and click enter
    Then  Validate whether the added Task is available in All and Available tab
    And   Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Delete two tasks by click on close button at the end of the task
    Then  Close the browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|