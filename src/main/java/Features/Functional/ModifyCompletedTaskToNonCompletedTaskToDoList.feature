Feature: Managing To Do List for Completing Task
 
 Scenario Outline: Complete a Task from ToDo List
    
    Given ModifyCompletedTask-Launch the To Do List URL
    When  ModifyCompletedTask-User enters a Task "<ModifyCompletingTask>" and click enter
    Then  ModifyCompletedTask-Task complete by clicking on RadioButton before the task
    And   ModifyCompletedTask-Click on the RadioButton again to change into NonCompleted task
    Then  Close the ModifyCompletedTask browser
    Examples: 
    |ModifyCompletingTask|
    |TestExecution       |