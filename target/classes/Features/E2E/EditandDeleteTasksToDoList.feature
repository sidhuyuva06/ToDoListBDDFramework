Feature: Managing To Do List for Editing and Deleting Tasks
@E2E
Scenario Outline: Editing two tasks from the added four tasks and Deleting two Tasks from ToDo List
    
    Given Edit&Delete-Launch the To Do List URL
    When  Edit&Delete-User enters four Tasks "<Task1>","<Task2>","<Task3>","<Task4>"  and click enter
    Then  Edit&Delete-Validate whether the added Task is available in All and Available tab
    And   Edit&Delete-Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Edit&Delete-Delete two tasks by click on close button at the end of the task
    Then  Close the Editing&DeletingTask browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|
    
   