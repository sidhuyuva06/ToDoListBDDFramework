# ToDoListBDDFramework
**Instructions to Run the Test:**

**GitHub:**

1. Clone this project repository from GitHub to your local machine.

**Eclipse:**

**Project Importing:**

1.	Open Eclipse IDE.
2.	Go to File->Import and Type Maven in the "Select an import wizard" textbox.
3.	Click on the Maven folder dropdown and choose Existing Maven Projects and click Next button.
4.	Browse the cloned project and choose the Folder and in the "Projects:" space pom.xml file will appear.
5.	Click on the checkbox before the pom.xml and click finish button.

**Project Configuration:**

1.	Go to Help->Marketplace and type cucumber in the Find Textbox
2.	On the plugins that gets listed click on install on Cucumber Eclipse Plugin and install the same and Restart Eclipse.
3.	Right click on the project and go to configure->Convert to Cucumber Project.
4.	Right click on the project and click on Maven->Update Project.
5.	Choose the cloned project to update and choose offline checkbox as well and click ok button.
6.	Wait till maven update is completed and the progress can be seen in the bottom right corner.

**Project Execution:**

1. Navigate and click on Test Runner.java file under src/main/java/My Runner.
2. In @cucumberOptions Provide features = "src/main/java/Features" to run all the scenarios.
3. In @cucumberOptions Provide features="src/main/java/Features/ProvideSpecificFeatureFileToRun" to run specific scenarios.
4. In @cucumberOptions Provide tags={"@E2E"} to run all end-to-end complex scenarios.
5. In @cucumberOptions Provide tags={"@Functional Scenarios"} to run all the basic functional scenarios.
6. In @cucumberOptions Provide tags={"@E2E","@FunctionalScenarios"} to run the scenarios one after the other
   only if the first one is successful.
7. In @cucumberOptions Provide tags={"@E2E, @FunctionalScenarios"} to run the scenarios one after the other
   even if the first one is failed.
8. In @cucumberOptions Provide tags=tags={~@E2E} to ignore the set of scenarios under this tag.
9. Refresh the project and go to ToDoListTestFramework/target/cucumber/test-output to view the test Results after running the tests.
   
