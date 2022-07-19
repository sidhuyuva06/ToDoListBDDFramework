Feature: Managing To Do List for Editing Task
@FunctionalScenarios  
Scenario Outline: Edit a Task in ToDo List
    Given Edit-Launch the To Do List URL
    When  Edit-User enters a Task "<Task>" and click enter
    Then  Edit-Double click on the Added Task, edit the task"<EditTask>"and click enter
    And   Close the EditTask browser

	  Examples: 
    |Task     |EditTask |
    |UserStory|Gromming |