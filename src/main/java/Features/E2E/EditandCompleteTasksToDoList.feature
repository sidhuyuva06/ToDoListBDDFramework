Feature: Managing To Do List for Editing and Completing Tasks
@E2E 
Scenario Outline: Editing two tasks from four added tasks and completing all the tasks in ToDo List
    
    Given Edit&Complete-Launch the To Do List URL
    When  Edit&Complete-User enters four Tasks "<Task1>","<Task2>","<Task3>","<Task4>"  and click enter
    Then  Edit&Complete-Validate whether the added Task is available in All and Available tab
    And   Edit&Complete-Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Edit&Complete-Task complete by clicking on RadioButton before the task
    And   Edit&Complete-Click on the Completion tab and validate the task availability
    Then  Edit&Complete-Click on Clear Completed
    Then  Edit&Complete-Close the Editing&CompleteTask browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|
    
   