Feature: Managing To Do List for Adding and Deletings Tasks
@E2E 
  Scenario Outline: Adding three tasks and Deleting two Tasks from ToDo List
  
    Given Add&Delete-Launch the To Do List URL
    When  Add&Delete-User enters a Task "<Task1>","<Task2>","<Task3>" and click enter
    And   Add&Delete-Validate whether the added Task is available in All and Available tab
    Then  Add&Delete-Delete two tasks by click on close button at the end of the task
    Then  Add&Delete-Click on the ToDoListDropDown to check the remaining non-deleted task
    Then  Close the Add&DeleteTask browser

	  Examples: 
    |Task1       |Task2       |Task3           |
    |Requirement |TestPlanning|TestCaseCreation|

		