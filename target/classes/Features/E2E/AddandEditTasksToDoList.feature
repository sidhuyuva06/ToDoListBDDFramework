	Feature: Managing To Do List for Adding and Editing Tasks 
@AddandEditTask 
  Scenario Outline: Adding four tasks and Editing two Tasks in ToDo List
  
    Given Add&Edit-Launch the To Do List URL
    When  Add&Edit-User enters four Tasks "<Task1>","<Task2>","<Task3>","<Task4>"  and click enter
    Then  Add&Edit-Validate whether the added Task is available in All and Available tab
    And   Add&Edit-Double click on the Added Task, edit the task"<EditTask1>","<EditTask2>"and click enter
    Then  Add&Edit-Validate the edited tasks are available by clicking on the ToDoListDropdown
    Then  Close the Adding&EditingTask browser

	  Examples: 
    |Task1    |Task2       |Task3         |Task4        |EditTask1|EditTask2        |
    |UserStory|TestPlanning|TestExecution |TestReporting|&Grooming|&TestcaseCreation|
    
   