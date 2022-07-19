Feature: Managing To Do List for Completing Task
@FunctionalScenarios  
Scenario Outline: Complete a Task from ToDo List
    
    Given Complete-Launch the To Do List URL
    When  Complete-User enters a Task "<CompletingTask>" and click enter
    Then  Complete-Task complete by clicking on RadioButton before the task
    And   Complete-Click on the Completion tab and validate the task availability
    And   Complete-Check whether completed task is crossed with a tick sign 
    And   Complete-Click on Clear Completed
    Then  Close the CompleteTask browser
    Examples: 
    |CompletingTask|
    |TestPlanning  |