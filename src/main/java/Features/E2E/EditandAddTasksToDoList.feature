Feature: Managing To Do List for Editing and Adding Tasks  
@E2E
Scenario Outline: Editing two tasks and Adding two tasks in ToDo List
   
    Given Edit&Add-Launch the To Do List URL
    When  Edit&Add-User enters two Tasks "<Task1>","<Task2>"and click enter
    Then  Edit&Add-Validate whether the added Task is available in All and Available tab
    And   Edit&Add-Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Edit&Add-User enters two more Tasks"<Task3>","<Task4>"and click enter
    Then  Edit&Add-Close the Editing&AddingTask browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|
    
   