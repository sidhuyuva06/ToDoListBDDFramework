Feature: Managing To Do List for Add and Delete Task
@FunctionalScenarios 
Scenario Outline: Add and Delete a Task in ToDo List
    
    Given Delete-Launch the To Do List URL
    When  Delete-User enters a Task "<Task1>" and click enter
    And   Delete-Validate whether the added Task is available in All and Available tab
    Then  Delete the task by click on close button at the end of the task
    Then  Close the DeleteTask browser

	  Examples: 
    |Task1       |
    |DeleteTask1 |
		

		