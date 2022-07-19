Feature: Managing To Do List for Completing and Deleting Tasks
 @E2E
 Scenario Outline: Completing three tasks and Deleting two tasks from ToDo List
 
    Given Complete&Delete-Launch the To Do List URL
    When  Complete&Delete-User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  Complete&Delete-Task complete by clicking on RadioButton before the task
    And   Complete&Delete-Click on the Completion tab and validate the task availability
    And   Complete&Delete-Delete two tasks by click on close button at the end of the task
    And   Complete&Delete-Validate whether the reamining non deleted task is available by clicking on ToDoListDropDown
    Then  Complete&Delete-Close the CompleteTask browser
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|
    |UserStoryGrooming|TestPlanning   |Test Automation |