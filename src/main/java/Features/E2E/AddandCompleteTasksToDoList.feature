Feature: Managing To Do List for Adding and Completing Tasks
@E2E
 Scenario Outline: Adding three tasks and Complete them using ToDo List
 
    Given Add&Complete-Launch the To Do List URL
    When  Add&Complete-User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  Add&Complete-Task complete by clicking on RadioButton before the task
    And   Add&Complete-Click on the Completion tab and validate the task availability
    Then  Add&Complete-Check whether completed task is crossed with a tick sign 
    And   Add&Complete-Click on Clear Completed
    Then  Add&Complete-Close the CompleteTask browser
    
    
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|
    |UserStoryGrooming|TestPlanning   |Test Automation |