Feature: Managing To Do List for Adding Task
@FunctionalScenarios 
  Scenario Outline: Add a Task in ToDo List
    Given Add-Launch the To Do List URL
    When  Add-User enters a Task "<Task>" and click enter
    Then  Add-Check whether the Task is added to To Do List
    And   Add-Validate whether the added Task is available in All and Available tab
    Then  Close the AddTask browser

	  Examples: 
    |Task        |
    |Requirements|
		

		