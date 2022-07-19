Feature: Managing To Do List for Completing and Adding Tasks
 @E2E
 Scenario Outline: Completing three Tasks and changing back to non completed tasks in ToDo List
 
    Given CompleteToNonComplete-Launch the To Do List URL
    When  CompleteToNonComplete-User enters a Task "<CompletingTask1>","<CompletingTask2>","<CompletingTask3>" and click enter
    Then  CompleteToNonComplete-Task complete by clicking on RadioButton before the task
    And   CompleteToNonComplete-Click on the Completion tab and validate the task availability
    And   CompleteToNonComplete-Task Make it as Non-Complete by clicking on RadioButton again before the task
    Then  CompleteToNonComplete-Validate whether the added Task is available in All and Available tab
    Then  CompleteToNonComplete-Close the CompleteToNonCompleteTask browser
   
    Examples: 
    |CompletingTask1  |CompletingTask2| CompletingTask3|
    |UserStoryGrooming|TestPlanning   |Test Automation |