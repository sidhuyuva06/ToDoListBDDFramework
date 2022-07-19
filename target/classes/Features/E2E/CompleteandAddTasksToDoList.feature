Feature: Managing To Do List for Completing and Adding Tasks
 @E2E
 Scenario Outline: Completing three Tasks and Adding two Tasks to ToDo List
 
    Given Complete&Add-Launch the To Do List URL
    When  Complete&Add-User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  Complete&Add-Task complete by clicking on RadioButton before the task
    And   Complete&Add-Click on the Completion tab and validate the task availability
    And   Complete&Add-Click on Clear Completed
    Then  Complete&Add-User adds Tasks "<AddTask1>","<AddTask2>" and click enter
    Then  Complete&Add-Validate whether the added Task is available in All and Available tab
    Then  Complete&Add-Close the CompleteAddTask browser
   
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|AddTask1     |AddTask2     |
    |UserStoryGrooming|TestPlanning   |Test Automation |TestExecution|TestReporting|