	Feature: Managing To Do List for Completing and Editing Tasks
@E2E
  Scenario Outline: Completing two tasks and Editing two Tasks in ToDo List
   
    Given Complete&Edit-Launch the To Do List URL
    When  Complete&Edit-User enters two Tasks"<Task1>","<Task2>"and click enter
    Then  Complete&Edit-Validate whether the added Task is available in All and Available tab
    Then  Complete&Edit-Task Complete task by clicking on RadioButton before the task
    And   Complete&Edit-Click on the Completion tab and validate the task availability
    And   Complete&Edit-Double click on the Completed Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Complete&Edit-Click on Clear Completed
    Then  Complete&Edit-Close the CompleteTask&Editing browser

	  Examples: 
    |Task1    |Task2       |EditTask1|EditTask2        |
    |UserStory|TestPlanning|&Grooming|&TestcaseCreation|
    
   