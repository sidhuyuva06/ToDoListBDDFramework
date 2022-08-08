package MyRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			 
			features = "src/main/java/Features/Functional",//To run all the feature files
		    //features="src/main/java/Features/E2E"//To run all the features under E2E
			//features="src/main/java/Features/Functional"//To run all the features under Functional"
			//To run specific feature files:
			//features="src/main/java/Features/E2E/SpecificFeature
			//features="src/main/java/Features/Functional/SpecificFeature
			glue={"stepDefinitions"}, //the path of the step definition files
			plugin= {"pretty","html:target/cucumber/test-output.html"}, //to generate a HTML Test Report
			monochrome = true, //display the console output in a proper readable format
			strict = true, //it will check if any step is not defined in step definition file
			dryRun = false //to check the mapping is proper between feature file and step definition file
			//tags = "@E2E" //to run all end to end complex scenarios.	
			//tags="@FunctionalScenarios"//to run all the basic functional scenarios.
			//tags={"@E2E","@FunctionalScenarios"} to run the scenarios one after the other only if the first one is successful
			//tags={"@E2E, @FunctionalScenarios"} to run the scenarios one after the other even if the first one is failed
			//tags={~@E2E} to ignore the set of scenarios under this tag
			)
	 
	public class TestRunner {
	 
	}
